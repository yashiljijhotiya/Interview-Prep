package DesignPattern.Mediator;

public class Aircraft {

    IATCMediator mediator;
    String flightName;

    public Aircraft(IATCMediator mediator, String flightName){
        this.flightName = flightName;
        this.mediator = mediator;
    }
}
