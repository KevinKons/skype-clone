package controller.chat;

import controller.Observed;
import controller.ObserverHome;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListenCalls extends Thread implements Observed {

    //56004
    private ServerSocket server;
    private Call call;
    private List<ObserverHome> observers = new ArrayList<>();

    @Override
    public void run() {
        try {
            server = new ServerSocket(56004);
            server.setReuseAddress(true);
            BufferedReader in = null;

            while (true) {
                Socket conn = server.accept();
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String opc = in.readLine();
                if (opc.equalsIgnoreCase("0")) {
                    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String nickname = in.readLine();

                    for (ObserverHome o : observers) {
                        o.notifiesUserIsCalling(nickname, conn.getInetAddress().getHostAddress());
                    }
                } else {
                    in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    //nickname ; ip
                    String[] info = in.readLine().split(";");
                    String nickname = info[0];
                    String ip = info[1];

                    for (ObserverHome o : observers) {
                        o.notifiesAcceptedCall(nickname, ip);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ListenCalls.class.getName()).log(Level.SEVERE, null, ex);
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
}
