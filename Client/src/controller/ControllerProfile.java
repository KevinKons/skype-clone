package controller;

import com.sun.javafx.geom.AreaOp;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Config;
import model.User;

public class ControllerProfile {

    public void update(User user) {

        try {
            Socket conn = new Socket(Config.getInstance().getAddress(), Config.getInstance().getPort());
        } catch (IOException ex) {
            Logger.getLogger(ControllerProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
