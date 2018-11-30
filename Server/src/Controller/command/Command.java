package Controller.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Kevin
 */
public interface Command {
    
    void execute(Socket conn, BufferedReader in) throws IOException;
    Command clonar();
}
