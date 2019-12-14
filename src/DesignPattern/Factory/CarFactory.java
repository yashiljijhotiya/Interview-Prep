package DesignPattern.Factory;

public class CarFactory {

    public static Car  createCar(CarType model){
        Car car = null;
        switch (model){
            case SEDAN:
                car = new SedanCar(model);
                break;
            case SMALL:
                car = new SUVCar(model);
                break;
            case LUXURY:
                car = new LuxuryCar(model);
                break;
            default:
                break;
        }

        return car;
    }
}
