package designPattern.factory;

/**
 * 简单工厂实例
 */
//圆形
public class Circle implements Shape {

    public Circle(){

    }
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
//正方形
class Rectangle implements Shape {
    public Rectangle() {
        System.out.println("Rectangle");
    }
    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}

//正方形
class Square implements Shape {
    public Square(){
        System.out.println("Square");
    }
    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}

