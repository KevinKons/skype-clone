package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Config;
import model.User;

public class ControllerProfile {

    public void update(User user) {

        try {
            //nickname; name; status
            Socket conn = new Socket(Config.getInstance().getAddress(), Config.getInstance().getPort());
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            out.println(2);
            String message = user.getNickname() + ";" + user.getName() + ";" + user.getStatus();
            out.println(message);

        } catch (IOException ex) {
            Logger.getLogger(ControllerProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
