package Controller.command;

import java.io.BufferedReader;
import java.net.Socket;

/**
 *
 * @author Kevin
 */
public class SignUp implements Command {

    @Override
    public void execute(Socket conn, BufferedReader in) {
        String nickname = 
    }

    @Override
    public Command clonar() {
        return new SignUp();
    }
    
}
