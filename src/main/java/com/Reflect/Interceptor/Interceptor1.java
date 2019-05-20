package com.Reflect.Interceptor;

import java.lang.reflect.Method;

/**
 * Created by zhulei on 2019/5/19.
 */
public class Interceptor1 implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("[拦截器1]的before方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("[拦截器1]的after方法");
    }
}
