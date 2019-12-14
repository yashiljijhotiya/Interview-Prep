package DesignPattern.Factory;

public class SedanCar extends Car{

    public  SedanCar(CarType model){
        super(model);
    }

    @Override
    protected void constructCar() {
        System.out.println("Sedan is created");
    }
}
