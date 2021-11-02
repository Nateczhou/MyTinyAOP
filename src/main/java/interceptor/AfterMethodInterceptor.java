package interceptor;

import invocator.MethodInvocator;

import java.lang.reflect.Method;

public class AfterMethodInterceptor implements MethodInterceptor{
    private Object aspObject;
    private Method aspMethod;

    public AfterMethodInterceptor(Object aspObject, Method aspMethod) {
        this.aspObject = aspObject;
        this.aspMethod = aspMethod;
    }

    @Override
    public Object invoke(MethodInvocator mi) throws Throwable {
        Object result = mi.proceed();
        aspMethod.setAccessible(true);
        aspMethod.invoke(aspObject);
        return result;
    }
}

