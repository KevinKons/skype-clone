package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import model.User;
import util.CloseConnection;

public class MaintainOnline extends Thread {

    //56000
    @Override
    public void run() {

        try {
            PrintWriter out;
            BufferedReader in;
            while (true) {
                ServerSocket server = new ServerSocket(56001);
                server.setReuseAddress(true);
                Socket conn = server.accept();
                
                System.out.println("maitain online foi chamado");

                out = new PrintWriter(conn.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                
                String info = in.readLine();
                if (info.equalsIgnoreCase("Are you alive?")) {
                    out.println("yes");
                } else if (info.equalsIgnoreCase("1")) {
                    handleUserLogout(in.readLine());
                } else {
                    handleUserLogin(in.readLine().split(";"));
                }
                CloseConnection.getInstance().close(in, out, conn);
                server.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void handleUserLogout(String ip) {
        List<User> contacts = ManageControllers.getInstance().getUser().getContacts();
        for (int i = 0; i < contacts.size(); i++) {
            User contact = contacts.get(i);
            if (contact.getIp().equalsIgnoreCase(ip)) {
                contact.setIp(null);
            }
        }
    }

    private void handleUserLogin(String[] info) {
        System.out.println("alguem entrou");
        User user = ManageControllers.getInstance().getUser();
        for(User contact : user.getContacts()) {
            if(contact.getNickname().equalsIgnoreCase(info[0]))
                contact.setIp(info[1]);
        }
    }
}
