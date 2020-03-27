package DesignPattern.Mediator;

public interface IATCMediator {

    public void registerRunway();
    public void registerFlight();
    public  boolean isLandingOK();
    public void setLandingStatus();
}
