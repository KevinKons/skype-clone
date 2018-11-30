package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaintainOnline extends Thread {

    //56000
    @Override
    public void run() {

        try {
            while (true) {
                ServerSocket server = new ServerSocket(56000);
                server.setReuseAddress(true);
                server.accept();
            }

        } catch (IOException ex) {
            Logger.getLogger(MaintainOnline.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
