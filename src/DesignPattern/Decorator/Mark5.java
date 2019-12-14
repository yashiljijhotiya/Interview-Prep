package DesignPattern.Decorator;

public class Mark5 extends Camera {

    public Mark5(String desc){
        description = desc;
    }

    @Override
    public double price() {
        return 350000;
    }

}
