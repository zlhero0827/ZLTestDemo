package SJMS;

/**
 * Created by zhulei on 2018/4/19.
 */
public class SingletonDemo {
    private static SingletonDemo instance;

    private SingletonDemo(){

    }

    public static SingletonDemo getInstance(){
        if(instance==null){
            instance = new SingletonDemo();
        }
        return instance;
    }

}
