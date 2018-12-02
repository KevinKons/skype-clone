package controller.contacts;

public class ControllerContacts {

    public void executeStrategy(Strategy strategy, String nickname)
            throws Exception {
        strategy.execute(nickname);
    }
}
