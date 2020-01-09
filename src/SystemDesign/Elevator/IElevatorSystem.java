package SystemDesign.Elevator;

import SystemDesign.Elevator.Enums.ElevatorDirection;
import SystemDesign.Elevator.Exception.InvalidNumber;

public interface IElevatorSystem {
    void callLift(int position) throws InvalidNumber;
    void setDestination(int destination) throws InvalidNumber;
    int getCurrentPosition();
    void setCurrentPosition(int currentFloor) throws InterruptedException;
    void setDirection(ElevatorDirection ed);
    ElevatorDirection getDirection();
}
