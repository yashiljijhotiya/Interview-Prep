package DesignPattern.Decorator;
//Driver class
public class CameraShop {

    public static void main(String[] args) {
        Camera cm = new MarK4("Mark 4 Camera");

        cm = new ZoomLensDecorator(cm);
        System.out.println(" Price :" + cm.price()  + "Description :" + cm.getDescription());
    }
}
