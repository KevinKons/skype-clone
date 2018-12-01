package controller;

import model.User;

public class ManageControllers {

    private static ManageControllers instance;
    private User user;

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

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}
