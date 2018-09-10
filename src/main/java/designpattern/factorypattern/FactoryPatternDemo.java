package designpattern.factorypattern;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory sf = new ShapeFactory();
        //获取Circle的对象，并调用它的draw方法
        Shape s1 = sf.getShape("CIRCLE");
        s1.draw();
        //获取Rectangle的对象，并调用它的draw方法
        Shape s2 = sf.getShape("Rectangle");
        s2.draw();
        //获取Square的对象，并调用它的draw方法
        Shape s3 = sf.getShape("Square");
        s3.draw();
    }
}
