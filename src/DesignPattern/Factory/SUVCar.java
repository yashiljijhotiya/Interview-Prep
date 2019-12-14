package DesignPattern.Factory;

public class SUVCar  extends Car{

    public SUVCar(CarType model){
        super(model);
        constructCar();
    }

    @Override
    protected void constructCar() {
        System.out.println("SUV car is created");
    }
}
