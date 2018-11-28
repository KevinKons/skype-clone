package Controller.command;

import Model.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin
 */
public class SignUp implements Command {

    @Override
    public void execute(Socket conn, BufferedReader in) throws IOException {
//        ObjectInputStream oIn = new ObjectInputStream(conn.getInputStream());
        
//        try {
//            User user = (User) oIn.readObject();
//            System.out.println(user.getIp());
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public Command clonar() {
        return new SignUp();
    }
    
}
