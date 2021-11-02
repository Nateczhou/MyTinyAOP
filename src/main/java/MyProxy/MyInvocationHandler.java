package MyProxy;

import advice.After;
import advice.Around;
import advice.Before;
import interceptor.AfterMethodInterceptor;
import interceptor.AroundMethodInterceptor;
import interceptor.BeforeMethodInterceptor;
import interceptor.MethodInterceptor;
import invocator.MethodInvocator;
import invocator.MyProxyMethodInvocator;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MyInvocationHandler implements InvocationHandler {

    private Object obj;
    private Object aspObj;

    public MyInvocationHandler(Object obj, Object aspObj) {
        this.obj = obj;
        this.aspObj = aspObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1. scan all method in aspObj, according to its annotation, create corresponding MethodInterceptor
        Class<?> aspectClass = aspObj.getClass();
        List<MethodInterceptor> list = new ArrayList<>();
        for (Method aspectMethod: aspectClass.getDeclaredMethods()) {
            for (Annotation annotation: aspectMethod.getDeclaredAnnotations()) {
                MethodInterceptor methodInterceptor = null;
                // each method may have multiple annotation, create their own method interceptor
                if (annotation.annotationType() == Before.class) {
                    methodInterceptor = new BeforeMethodInterceptor(aspObj, aspectMethod);
                } else if (annotation.annotationType() == After.class) {
                    methodInterceptor = new AfterMethodInterceptor(aspObj, aspectMethod);
                } else if (annotation.annotationType() == Around.class) {
                    methodInterceptor = new AroundMethodInterceptor(aspObj, aspectMethod);
                }
                list.add(methodInterceptor);
            }
        }

        // fixed implementation for customized invocator
        MethodInvocator mi = new MyProxyMethodInvocator(list, obj, method, args);

        return mi.proceed();
    }
}
