package Proxy;

import java.util.Scanner;

public class Client {
    static DroneProxy droneProxy = new DroneProxy();

    public static void main(String[] args) {

        // perpetual loop that received pilot actions
        while (true) {

            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();

            switch (action) {
                case "left": {
                    droneProxy.turnLeft();
                    break;
                }

                case "right": {
                    droneProxy.turnRight();
                    break;
                }

                case "fire": {
                    droneProxy.fireMissile();
                    break;
                }

                default:
                    System.out.println("Invalid Action");
            }
        }
    }
}
