package Memento;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BlackBox implements Serializable {

    private long altitude;
    private double speed;
    private float engineTemperature;
    private static final long serialVersionUID = 1L;

    public String toString() {
        return "Altitude: " + altitude + "\nSpeed: " + speed + "\nTemp: " + engineTemperature;
    }

    public BlackBox(long altitude, double speed, float engineTemperature) {
        this.setAltitude(altitude);
        this.setSpeed(speed);
        this.setEngineTemperature(engineTemperature);
    }

    public float getEngineTemperature() {
        return engineTemperature;
    }

    public void setEngineTemperature(float engineTemperature) {
        this.engineTemperature = engineTemperature;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public long getAltitude() {
        return altitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    // Saving the state of the object as a byte stream
    public byte[] getState() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        byte[] memento = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(this);
            out.flush();
            memento = bos.toByteArray();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return memento;
    }

    // Restoring state from memento
    public BlackBox setState(byte[] memento) throws Exception {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(memento);

            ObjectInputStream objectInputStream = new ObjectInputStream(bis);
            BlackBox blackBox = (BlackBox) objectInputStream.readObject();
            objectInputStream.close();
            return blackBox;
        } catch (IOException e) {
            return null;
        }
    }

}