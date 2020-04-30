package designPattern.factory;

public class RectangleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
