package DesignPattern.Adapter;

public class Adapter implements IAircraft {

    HotAirBaloon hotAirBaloon;

    public Adapter(HotAirBaloon hotAirBaloon){
        this.hotAirBaloon = hotAirBaloon;
    }

    public void fly(){
    String fuelUsed = hotAirBaloon.inflateWithGas();
    hotAirBaloon.fly(fuelUsed);
    }

}
