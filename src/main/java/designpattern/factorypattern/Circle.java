package designpattern.factorypattern;

/**
 * 创建实现接口的实体类
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
