package controller;

import java.net.ServerSocket;

public class ListenIncommingServerMessages extends Thread {

    private static ListenIncommingServerMessages instance;
    private ServerSocket serverSocket;
    private ControllerContacts controllerContacts;

    //56001
    private ListenIncommingServerMessages(){}

    public synchronized static ListenIncommingServerMessages getInstance(){
        if (instance == null)
            instance = new ListenIncommingServerMessages();

        return instance;
    }

    @Override
    public void run() {

    }
}
