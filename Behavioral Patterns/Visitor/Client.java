package Visitor;

import java.util.Iterator;

public class Client {

    public static void main(String args[]) {
        Airforce airforce = new Airforce();
        Iterator<IAircraft> planes = airforce.getIterator();
        MetricsVisitor aircraftVisitor = new MetricsVisitor();

        while (planes.hasNext()) {
            planes.next().accept(aircraftVisitor);
        }

        aircraftVisitor.printAccumulatedResults();
    }
}