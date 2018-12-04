package controller.chat;

import controller.ManageControllers;
import controller.Observed;
import controller.ObserverHome;
import model.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ListenMessages extends Thread implements Observed {

    //56002
    private ServerSocket serverSocket;
    private List<ObserverHome> observers = new ArrayList<>();

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(56003);
            serverSocket.setReuseAddress(true);
            while (true) {
                System.out.println("Waiting connection");
                Socket conn = serverSocket.accept();
                System.out.println("Aceitou");
                try {
                    //Getting the message
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String message[] = in.readLine().split(";");

                    //Locating the sender through of IP
                    String nickname = message[0];
                    String content = message[1];
                    //Insert the message in Chat with the sender
                    if (ManageControllers.getInstance().getUser().getChats() != null) {
                        for (Chat chat : ManageControllers.getInstance().getUser().getChats()) {
                            if (chat.getNickname().equalsIgnoreCase(nickname)) {
                                chat.addMenssage(content);
                            }
                        }
                    } else {
                        Chat chat = new Chat(nickname, content);
                        ManageControllers.getInstance().getUser().addChat(chat);
                    }
                    addMessage(content);
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addObserver(ObserverHome obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(ObserverHome obs) {
        observers.remove(obs);
    }
    
    private void addMessage(String message){
        for(ObserverHome obs: observers){
            obs.addMessage(message);
        }
    }
    
}
