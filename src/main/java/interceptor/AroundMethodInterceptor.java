package interceptor;

import invocator.MethodInvocator;

import java.lang.reflect.Method;

public class AroundMethodInterceptor implements MethodInterceptor{

    private Object aspObject;
    private Method aspMethod;

    public AroundMethodInterceptor(Object aspObject, Method aspMethod) {
        this.aspObject = aspObject;
        this.aspMethod = aspMethod;
    }

    @Override
    public Object invoke(MethodInvocator mi) throws Throwable {
        aspMethod.setAccessible(true);
        return aspMethod.invoke(aspObject, mi);
    }
}
