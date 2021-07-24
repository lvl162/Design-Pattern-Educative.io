package Memento;

public class Client {

    public static void main(String args[]) throws Exception {
        BlackBox blackBox = new BlackBox(10, 20f, 30f);

        // Save the state of the memento as a byte stream.
        byte[] memento = blackBox.getState();

        // Do some work.
        blackBox.setAltitude(69);
        blackBox.setEngineTemperature(69.9f);
        System.out.println(blackBox.toString());
        // Now restore the blackbox to the previous state
        blackBox = blackBox.setState(memento);
        System.out.println(blackBox.toString());

    }

}