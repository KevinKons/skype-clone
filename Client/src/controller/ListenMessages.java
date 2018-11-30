package controller;

import model.Chat;
import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenMessages extends Thread {

    //56002
    private ServerSocket serverSocket;

    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(56001);
            serverSocket.setReuseAddress(true);

            while (true) {

                System.out.println("Waiting connection");
                Socket conn = serverSocket.accept();

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


                } catch (IOException e) {

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
