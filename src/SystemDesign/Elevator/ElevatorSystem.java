package SystemDesign.Elevator;
import DesignPattern.Singleton.Singleton;
import SystemDesign.Elevator.Enums.ElevatorDirection;
import SystemDesign.Elevator.Enums.ElevatorStatus;
import SystemDesign.Elevator.Exception.InvalidNumber;
import java.util.TreeSet;

public class ElevatorSystem implements IElevatorSystem{

    private static Elevator elevator;
    private int maxPeople = 10;
    private int maxWeight = 650;
    private TreeSet<Integer> upcomingRequest;
    private Thread requestProcessor;

    private ElevatorSystem(){
        upcomingRequest = new TreeSet<>();
    }

    @Override
    public void callLift(int position) throws InvalidNumber {
     addRequest(position);
     Integer floor = null;
     if(elevator.getDirection() == ElevatorDirection.UP){
         if(upcomingRequest.ceiling(position) != null){
             floor = upcomingRequest.ceiling(position);
         }
         else {
             floor = upcomingRequest.floor(position);
         }
     }
     else {
         if(upcomingRequest.floor(position) != null){
             floor = upcomingRequest.floor(position);
         }
         else {
             floor = upcomingRequest.ceiling(position);
         }
     }

     if(floor == null){
         try {
             System.out.println("Waiting at floor :" + getCurrentPosition());
             wait();
         }catch (InterruptedException e){
             e.printStackTrace();
         }
     }
     else {
       upcomingRequest.remove(position);
     }
    }

    @Override
    public void setDestination(int destination) throws InvalidNumber {
        if(checkCapacity()){
            throw new InvalidNumber("Sorry lift is full, try next time !!");
        }
        else {
            callLift(destination);
        }
    }

    @Override
    public int getCurrentPosition() {
        return elevator.getCurrentPosition();
    }

    @Override
    public void setCurrentPosition(int currentFloor) throws  InterruptedException{
        elevator.setCurrentPosition(currentFloor);
        if(elevator.getCurrentPosition() > currentFloor){
            setDirection(ElevatorDirection.DOWN);
        }else {
            setDirection(ElevatorDirection.UP);
        }
        Thread.sleep(3000);

    }

    @Override
    public void setDirection(ElevatorDirection ed) {
       elevator.setDirection(ed);
    }

    @Override
    public ElevatorDirection getDirection() {
        return elevator.getDirection();
    }

    private boolean checkCapacity(){
        if(elevator.getPersonCapacity() > maxPeople || elevator.getWeightCapacity() > maxWeight)
            return false;
        else
            return true;
    }

    private void move(){
      if(elevator.currentPosition == elevator.maxFloor){
          elevator.setDirection(ElevatorDirection.DOWN) ;
      }
      if(elevator.currentPosition == elevator.minFloor){
          elevator.setDirection(ElevatorDirection.UP);
      }
    }

    private synchronized void addRequest(int floorNo) throws  InvalidNumber{
        if(floorNo > elevator.maxFloor || floorNo < elevator.minFloor){
            throw new InvalidNumber("Please enter the valid floor no.");
        }
        else {
            upcomingRequest.add(floorNo);
        }
        if(requestProcessor.getState() == Thread.State.WAITING){
            notify();
        }
        else {
            requestProcessor.interrupt();
        }
    }

    public static Elevator getElevator(){
        if(elevator == null){
            synchronized (Singleton.class){
                if(elevator == null){
                    elevator = new Elevator(1,5,460,ElevatorDirection.NONE, ElevatorStatus.NONE,true,false,0,0,20,0 );
                }
            }
        }
        return  elevator;
    }

}
