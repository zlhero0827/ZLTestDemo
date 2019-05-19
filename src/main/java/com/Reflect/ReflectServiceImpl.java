package com.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zhulei on 2019/5/18.
 */
public class ReflectServiceImpl {
    public void sayHello(String name){
        System.err.println("Hello "+name);
    }

    public void login(String username,String password){
        System.err.println("username "+username+"|password "+password);
    }

    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.Reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException |IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 代理方法单参数
     * @return
     */
    public Object reflectMethod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello",String.class);
            returnObj = method.invoke(target,"Method+July");
        } catch (NoSuchMethodException |IllegalAccessException |InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;

    }

    /**
     * 代理方法有多个参数示例
     * @return
     */
    public Object reflectMethodMutil(){
        Object obj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("login", String.class, String.class);
            obj = method.invoke(target,"July","123123");
        } catch (NoSuchMethodException |IllegalAccessException |InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 反射生成对象+反射调度方法
//     * @param args
     */
    public Object reflect(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.Reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object,"July+classforname");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException |NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        ReflectServiceImpl  rsi = new ReflectServiceImpl();
        rsi.reflect();
        rsi.reflectMethodMutil();
        rsi.reflectMethod();
//        rsi.getInstance().sayHello("July");
    }
}
