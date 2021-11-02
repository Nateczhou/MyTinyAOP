package invocator;

import interceptor.MethodInterceptor;

import java.lang.reflect.Method;
import java.util.List;

public class MyProxyMethodInvocator implements MethodInvocator{

    // need to store origin method and an list of aspect method Interceptor
    private List<MethodInterceptor> list;
    private Object obj;
    private Method method;
    private Object[] args;
    // a state variable for the instance
    private int index;

    public MyProxyMethodInvocator(List<MethodInterceptor> list, Object obj, Method method, Object[] args) {
        this.list = list;
        this.obj = obj;
        this.method = method;
        this.args = args;
        this.index = 0;
    }

    @Override
    public Object proceed() throws Throwable{
        if (index >= list.size()) {
            return method.invoke(obj, args);
        }
        MethodInterceptor interceptor = list.get(index++);
        return interceptor.invoke(this);
    }
}
