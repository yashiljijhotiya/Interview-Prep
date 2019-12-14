package DesignPattern.Decorator;

public class ZoomLensDecorator extends  CameraAccessoriesDecorator {

    Camera camera;
    public ZoomLensDecorator(Camera camera){
        this.camera = camera;
    }

    @Override
    public String getDescription() {
        return camera.getDescription() + "Zoom lens";
    }

    @Override
    public double price() {
        return camera.price() + 300000;
    }
}
