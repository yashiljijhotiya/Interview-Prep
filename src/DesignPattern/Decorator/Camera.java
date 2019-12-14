package DesignPattern.Decorator;

public abstract class Camera {

    protected String description;

    public String getDescription(){
        return description;
    }
    public abstract double price();
}
