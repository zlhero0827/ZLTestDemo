package com.Reflect.Interceptor;

import java.lang.reflect.Method;

/**
 * Created by zhulei on 2019/5/19.
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法前逻辑");
        return false;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("取代了被代替对象的方法");

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.err.println("反射方法后的逻辑");
    }
}
