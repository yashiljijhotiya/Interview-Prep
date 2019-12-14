package DesignPattern.Factory;

public class DriverFactory {

    public static void main(String[] args) {
        System.out.println(CarFactory.createCar(CarType.LUXURY));
        System.out.println(CarFactory.createCar(CarType.SEDAN));
        System.out.println(CarFactory.createCar(CarType.SMALL));
    }
}
