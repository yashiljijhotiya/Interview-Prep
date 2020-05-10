package DesignPattern.AbstractFactory;

public class Rafale implements IAircraftFactory {
    @Override
    public IEngine createEngine() {
        return null;
    }

    @Override
    public ICockpit createCockpit() {
        return null;
    }

    @Override
    public IWings createWings() {
        return null;
    }
}
