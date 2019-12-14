package DesignPattern.Decorator;

public class MarK4 extends Camera{

    public MarK4(String desc){
        description = desc;
    }

    @Override
    public double price() {
        return 150000;
    }
}
