import advice.After;
import advice.Around;
import advice.Before;
import invocator.MethodInvocator;

public class BMWAspect {

    @Around
    Object aroundFunc1(MethodInvocator mi) throws Throwable {
        System.out.println("This is the beginning in around");
        Object result = mi.proceed();
        System.out.println("This is the end in around");
        return result;
    }

    @Before
    void beforeFunc1() {
        System.out.println("This is in before!");
    }

    @After
    void afterFunc1() {
        System.out.println("This is in after!");
    }



}
