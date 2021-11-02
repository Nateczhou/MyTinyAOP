import MyProxy.MyInvocationHandler;

import java.lang.reflect.Proxy;

public class TestDriver {


    public static void main(String[] args) {
        Object obj = new BMW();
        Object aspObj = new BMWAspect();
        Car car = (Car) Proxy.newProxyInstance(obj.getClass().getClassLoader(),  obj.getClass().getInterfaces(), new MyInvocationHandler(obj, aspObj));
        System.out.println(car.getBrand());
    }
}
