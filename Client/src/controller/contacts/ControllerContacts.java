package controller.contacts;

public class ControllerContacts {

    private Strategy strategy;
    
    public void execute(String nickname) throws Exception {
        strategy.execute(nickname);
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
