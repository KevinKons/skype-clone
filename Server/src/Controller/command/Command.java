package Controller.command;

import java.io.BufferedReader;
import java.net.Socket;

/**
 *
 * @author Kevin
 */
public interface Command {
    
    void execute(Socket conn, BufferedReader in);
    Command clonar();
}
