package controller;

import model.User;

public class ManageControllers {

    private static ManageControllers instance;
    private User user;

    //Control
    private ChatController chatController;

    //Listeners
    private ListenCalls listenCalls;
    private ListenMessages listenMessages;
    private ListenIncommingServerMessages listenIncommingServerMessages;

    private ManageControllers(){}

    public synchronized static ManageControllers getInstance(){
        if (instance == null){
            instance = new ManageControllers();
        }

        return instance;
    }

    public void initControllers(){

        //Controller
        chatController = new ChatController(user);

        //Listeners
        listenCalls = new ListenCalls();
        listenCalls.start();

        listenMessages = new ListenMessages();
        listenMessages.start();

        listenIncommingServerMessages.getInstance().run();

    }

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

}
