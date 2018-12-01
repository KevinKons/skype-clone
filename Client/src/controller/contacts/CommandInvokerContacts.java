package controller.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kevin
 */
public class CommandInvokerContacts {

    private Map<Integer, Command> commands = new HashMap<>();

    public CommandInvokerContacts() {
        commands.put(0, new AddContact());
        commands.put(1, new RemoveContact());
        commands.put(2, new ChangeContactOnlineStatus());
    }

    public void execute(int option, String nickname) throws IOException {
        Command comm = commands.get(option).clonar();
        comm.execute(nickname);
    }

}
