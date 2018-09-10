package designpattern;

/**
 * 设计模式：单例模式
 */
public class SingletonObject {
    private static  SingletonObject instance = new SingletonObject();
    private SingletonObject (){}
    public static SingletonObject getInstance(){
        return instance;
    }
}
