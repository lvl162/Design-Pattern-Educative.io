package State;

public class TaxiState implements IPilotActions {
    F16 f16;

    // Notice, how the state class is composed with the context object
    public TaxiState(F16 f16) {
        this.f16 = f16;
    }
    @Override
    public void pilotTaxies(F16 f16) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pilotFlies(F16 f16) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pilotEjects(F16 f16) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pilotLands(F16 f16) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pilotParks(F16 f16) {
        // TODO Auto-generated method stub
        
    }
}