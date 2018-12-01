package controller;

import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ControllerContacts {

    private Socket socket;

    public ControllerContacts(Socket socket) {
        this.socket = socket;
    }

    public void addContact(String nickname) {
        printWriter(3, nickname);
    }

    public void changeContactOnlineStatus(User user) {

    }

    public void removeContact(String nickname) {
        printWriter(4, nickname);
    }

    private void printWriter(int code, String nickname) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String message = code + "," + nickname;
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
