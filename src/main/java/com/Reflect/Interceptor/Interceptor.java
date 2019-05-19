package com.Reflect.Interceptor;

import java.lang.reflect.Method;

/**
 * Created by zhulei on 2019/5/19.
 */
public interface Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args);

    public void around(Object proxy, Object target, Method method, Object[] args);

    public void after(Object proxy,Object target, Method method, Object[] args);
}

