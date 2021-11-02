package interceptor;

import invocator.MethodInvocator;

import java.lang.reflect.Method;

public class BeforeMethodInterceptor implements MethodInterceptor{

    private Object aspObject;
    private Method aspMethod;

    public BeforeMethodInterceptor(Object aspObject, Method aspMethod) {
        this.aspObject = aspObject;
        this.aspMethod = aspMethod;
    }

    @Override
    public Object invoke(MethodInvocator mi) throws Throwable{
        aspMethod.setAccessible(true);
        aspMethod.invoke(aspObject);
        return mi.proceed();
    }
}
