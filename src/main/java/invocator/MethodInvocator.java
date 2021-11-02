package invocator;

// an interface for process Method Interceptor

public interface MethodInvocator {

    Object proceed() throws Throwable;
}
