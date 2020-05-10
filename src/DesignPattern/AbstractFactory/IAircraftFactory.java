package DesignPattern.AbstractFactory;

public interface IAircraftFactory {
    IEngine createEngine();
    ICockpit createCockpit();
    IWings createWings();
}
