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
import model.User;

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
                    User user = ManageControllers.getInstance().getUser();
                    
                    //Insert the message in Chat with the sender
                    if (user.getChats() != null) {
                        Chat chat = null;
                        for (Chat c : user.getChats()) {
                            if (c.getNickname().equals(nickname)) {
                                chat = c;
                                c.addMenssage(content, nickname);
                                break;
                            }
                        }
                        
                        if(chat == null){
                            chat = new Chat(nickname, content);
                            user.addChat(chat);
                        }
                        
                    } else {
                        Chat chat = new Chat(nickname, content);
                        user.addChat(chat);
                    }

                    showMessages(nickname + ": " + content + "\n");
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

    private void showMessages(String message) {
        for (ObserverHome obs : observers) {
            obs.addMessage(message);
        }
    }

}
