package designPattern.factory;

public class SquareFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Square();
    }
}
