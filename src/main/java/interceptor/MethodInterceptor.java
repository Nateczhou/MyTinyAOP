package interceptor;
import invocator.MethodInvocator;

// An interface for encapculate java Method and the customized logic fgr invoke it

public interface MethodInterceptor {

    Object invoke(MethodInvocator mi) throws Throwable;
}
