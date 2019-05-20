package com.Reflect.Interceptor;

import com.Reflect.JDK.HelloWorld;
import com.Reflect.JDK.HelloWorldImpl;

import java.lang.reflect.Method;

/**
 * Created by zhulei on 2019/5/19.
 */
public class Interceptor3 implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("[拦截器3]的before方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("[拦截器3]的after方法");
    }

    public static void main(String[] args) {
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.Reflect.Interceptor.Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,
                "com.Reflect.Interceptor.Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2,
                "com.Reflect.Interceptor.Interceptor3");
        proxy3.sayHelloWorld();
    }
}
