// this is a class implements Car interface which will become the to be proxied class

public class BMW implements Car{
    @Override
    public String getBrand() {
        System.out.println("This is inside of BMW getBrand().");
        return "BMW";
    }

    @Override
    public void driver() {
        System.out.println("Your BMW is running ~");
    }
}
