package controller;

import java.net.ServerSocket;

public class ListenIncommingServerMessages extends Thread {

    private static ListenIncommingServerMessages instance;
    private ServerSocket serverSocket;
    private ControllerContacts controllerContacts;

    private ListenIncommingServerMessages(){}

    public synchronized ListenIncommingServerMessages getInstance(){
        if (instance == null)
            instance = new ListenIncommingServerMessages();

        return instance;
    }

    @Override
    public void run() {

    }
}
