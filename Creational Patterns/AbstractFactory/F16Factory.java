package AbstractFactory;

public class F16Factory implements IAircraftFactory {

    @Override
    public IEngine createEngine() {
        return new F16Engine();
    }

    @Override
    public IWings createWings() {
        return new F16Wings();
    }

    @Override
    public ICockpit createCockpit() {
        return new F16Cockpit();
    }
}

class F16Engine implements IEngine {
}

class F16Wings implements IWings {
}

class F16Cockpit implements ICockpit {
}