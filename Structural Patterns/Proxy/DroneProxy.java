package Proxy;

public class DroneProxy implements IDrone {
    final Drone drone = new Drone();

    @Override
    public void turnLeft() {
        drone.turnLeft();
        // forward request to the real drone to
        // turn left over the internet
    }

    @Override
    public void turnRight() {
        drone.turnRight();
        // forward request to the real drone to
        // turn right over the internet
    }

    @Override
    public void fireMissile() {
        drone.fireMissile();
        // forward request to the real drone to
        // fire missile
    }
}