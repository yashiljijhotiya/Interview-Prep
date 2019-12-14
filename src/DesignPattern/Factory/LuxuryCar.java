package DesignPattern.Factory;

public class LuxuryCar  extends Car{

    public  LuxuryCar(CarType model){
        super(model);
        constructCar();
    }

    @Override
    protected void constructCar() {
        System.out.println("Luxury Car is created");
    }


}
