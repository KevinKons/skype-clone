package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class MaintainOnline extends Thread implements Observed {

    private List<ObserverHome> observers = new ArrayList<>();

    //56001
    @Override
    public void run() {

        try {
            PrintWriter out;
            BufferedReader in;
            ServerSocket server = new ServerSocket(56001);
            server.setReuseAddress(true);
            while (true) {

                Socket conn = server.accept();

                out = new PrintWriter(conn.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String info = in.readLine();
//                System.out.println("INFO: " + info);
                if (info.equalsIgnoreCase("Are you alive?")) {
                    out.println("yes");
                } else if (info.equalsIgnoreCase("1")) {
                    handleUserLogout(in.readLine());
                } else {
                    handleUserLogin(in.readLine().split(";"));
                }
                conn.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void handleUserLogout(String nickname) {
        List<User> contacts = ManageControllers.getInstance().getUser().getContacts();        
        for (int i = 0; i < contacts.size(); i++) {
            User contact = contacts.get(i);
            if (contact.getNickname().equalsIgnoreCase(nickname)) {
                contact.setIp(null);
            }
        }
        System.out.println("Este nickname: " + nickname + " ficou offline");
        notifiesLogout(nickname);
    }

    private void handleUserLogin(String[] info) {
        System.out.println("Este nickname: " + info[0] + " ficou online");
        User user = ManageControllers.getInstance().getUser();
        for (User contact : user.getContacts()) {
            if (contact.getNickname().equalsIgnoreCase(info[0])) {
                contact.setIp(info[1]);
            }
        }
        notifieUserLogin(info[0]);
    }

    @Override
    public void addObserver(ObserverHome obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(ObserverHome obs) {
        observers.remove(obs);
    }

    private void notifieUserLogin(String nickname) {
        for (ObserverHome obs : observers) {
            obs.notifiesUserLogin(nickname, "");
        }
    }

    private void notifiesLogout(String nickname) {
        for (ObserverHome obs : observers) {
            obs.notifiesUserLogout(nickname);
        }
    }

}
