package Composition;

public class C130Hercules implements IAircraft, IAlliancePart {

    @Override
    public int getPersonnel() {
        // This cargo plane, needs 5 people
        return 5;
    }
    @Override
    public void fly() {
        System.out.println("C130Hercules is flying..");
    }
}