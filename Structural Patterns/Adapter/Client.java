package Adapter;

/**
 * Client
 */
public class Client {

    public void main() {

        HotAirBalloon hotAirBalloon = new HotAirBalloon();
        Adapter hotAirBalloonAdapter = new Adapter(hotAirBalloon);

        hotAirBalloonAdapter.fly();
    }
}