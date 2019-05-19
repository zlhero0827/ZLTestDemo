package com.Reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by zhulei on 2019/5/18.
 */
public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name){
        this.name = name;
    }

    public void sayHello(String name){
        System.err.println("Hello "+name);
    }

    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.Reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("July");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }



    public static void main(String[] args) {
        ReflectServiceImpl2 rsi2 = new ReflectServiceImpl2("xiaohong");
        rsi2.getInstance();
//        rsi2.getInstance().sayHello("xiaoming");
    }
}
