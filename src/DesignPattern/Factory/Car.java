package DesignPattern.Factory;

public abstract class Car {
    private CarType model;
    public Car(CarType model){
        this.model = model;
    }
    protected abstract void constructCar();
}
