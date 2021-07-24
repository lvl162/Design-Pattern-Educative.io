package Singleton;

public class Client {

    public static void main(String[] args) {
        AirforceOne airforceOne = AirforceOne.getInstance();
        airforceOne.fly();
    }
}