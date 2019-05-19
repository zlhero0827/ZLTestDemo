package com.Reflect.Interceptor;

import com.Reflect.JDK.HelloWorld;
import com.Reflect.JDK.HelloWorldImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhulei on 2019/5/19.
 */
public class InterceptorJdkProxy implements InvocationHandler {
    //真实对象
    private Object target;
    //拦截器全限定名
    private String inceterceptorClass = null;

    public InterceptorJdkProxy(Object target, String inceterceptorClass){
        this.target = target;
        this.inceterceptorClass = inceterceptorClass;
    }

    /**
     * 绑定委托对象并返回一个【代理占位】
     * @param target 真实对象
     */
    public static Object bind(Object target, String inceterceptorClass){
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target,inceterceptorClass));

    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     * @param proxy     代理对象
     * @param method    代理方法
     * @param args      方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(inceterceptorClass == null){
            //没设置拦截器直接反射原有方法
            return method.invoke(target,args);
        }
        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(inceterceptorClass).newInstance();
        //调用前置方法
        if(interceptor.before(proxy,target,method,args)){
            //反射原有方法
            method.invoke(target,args);
        }else {
            //false执行around方法
            interceptor.around(proxy,target,method,args);
        }
        //调用后置方法
        interceptor.after(proxy,target,method,args);
        return result;
    }

    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.Reflect.Interceptor.MyInterceptor");
        proxy.sayHelloWorld();
    }
}
