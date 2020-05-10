package DesignPattern.AbstractFactory;

public class Aircraft {

    private IEngine engine;
    private ICockpit cockpit;
    private IWings wings;
    private IAircraftFactory aircraftFactory;

    public Aircraft(IAircraftFactory aircraftFactory){
        this.aircraftFactory = aircraftFactory;
    }

    protected  Aircraft makeAirCraft(){
        return this;
    }

    private void ready(){
        System.out.println("ready to test on runway!");
    }


    protected  void fly(){
        Aircraft aircraft = makeAirCraft();
        aircraft.ready();
        System.out.println("Flying");
    }
}
