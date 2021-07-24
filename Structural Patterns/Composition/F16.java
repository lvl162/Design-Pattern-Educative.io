package Composition;

public class F16 implements IAircraft, IAlliancePart {

    @Override
    public int getPersonnel() {
        // We need 2 pilots for F-16
        return 2;
    }

    @Override
    public void fly() {
        System.out.println("F16 is flying..");
    }
}