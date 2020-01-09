package SystemDesign.Elevator;

import SystemDesign.Elevator.Enums.ElevatorDirection;
import SystemDesign.Elevator.Enums.ElevatorStatus;

public class Elevator {
    int id;
    int noOfPerson;
    double weightOfPerson;
    ElevatorDirection direction;
    ElevatorStatus status;
    boolean closeDoor;
    boolean openDoor;
    int currentPosition;
    int destination;
    int maxFloor;
    int minFloor;

    public Elevator(int id, int noOfPerson, double weightOfPerson, ElevatorDirection direction, ElevatorStatus status, boolean closeDoor, boolean openDoor, int currentPosition, int destination, int maxFloor, int minFloor) {
        this.id = id;
        this.noOfPerson = noOfPerson;
        this.weightOfPerson = weightOfPerson;
        this.direction = direction;
        this.status = status;
        this.closeDoor = closeDoor;
        this.openDoor = openDoor;
        this.currentPosition = currentPosition;
        this.destination = destination;
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
    }

    public int getId() {
        return id;
    }

    public int getPersonCapacity() {
        return noOfPerson;
    }

    public double getWeightCapacity() {
        return weightOfPerson;
    }

    public ElevatorDirection getDirection() {
        return direction;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public boolean isCloseDoor() {
        return closeDoor;
    }

    public boolean isOpenDoor() {
        return openDoor;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getDestination() {
        return destination;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPersonCapacity(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public void setWeightCapacity(double weightOfPerson) {
        this.weightOfPerson = weightOfPerson;
    }

    public void setDirection(ElevatorDirection direction) {
        this.direction = direction;
    }

    public void setStatus(ElevatorStatus status) {
        this.status = status;
    }

    public void setCloseDoor(boolean closeDoor) {
        this.closeDoor = closeDoor;
    }

    public void setOpenDoor(boolean openDoor) {
        this.openDoor = openDoor;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", personCapacity=" + noOfPerson +
                ", weightCapacity=" + weightOfPerson +
                ", direction=" + direction +
                ", status=" + status +
                ", closeDoor=" + closeDoor +
                ", openDoor=" + openDoor +
                ", currentPosition=" + currentPosition +
                ", destination=" + destination +
                ", maxFloor=" + maxFloor +
                ", minFloor=" + minFloor +
                '}';
    }
}
