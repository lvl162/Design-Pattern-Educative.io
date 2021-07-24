package Proxy;

public class Drone implements IDrone {

    @Override
    public void turnLeft() {
        // receives the request and any method parameters
        // over the internet to turn the drone to its left.
        System.out.println("LEFT");
    }

    @Override
    public void turnRight() {
        // receives the request and any method parameters
        // over the internet to turn the drone to its right.
        System.out.println("RIGHT");

    }

    @Override
    public void fireMissile() {
        System.out.println("MISSILE");

        // receives the request and any method parameters
        // over the internet to fire a missile
    }
}