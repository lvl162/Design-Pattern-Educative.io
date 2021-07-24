package Mediator;

public class Client {
    public static void main(String[] args) {
        ControlTower controlTower = new ControlTower();
        IAircraft f16 = new F16(controlTower);
        ((F16) f16).requestControlTowerToLand();
        controlTower.run();
    }

}
