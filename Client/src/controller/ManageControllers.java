package controller;

import model.User;

public class ManageControllers {

    private static ManageControllers instance;
    private User user;

    private ListenIncommingServerMessages listenIncommingServerMessages = ListenIncommingServerMessages.getInstance();

    private ManageControllers() {
    }

    public synchronized static ManageControllers getInstance() {
        if (instance == null) {
            instance = new ManageControllers();
        }

        return instance;
    }

    public void initControllers() {

        //Controller
        ChatController chatController = new ChatController(user);

        //Listeners
        ListenCalls listenCalls = new ListenCalls();
        listenCalls.start();

        ListenMessages listenMessages = new ListenMessages();
        listenMessages.start();

        listenIncommingServerMessages.run();

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
