package Controller.command;


/**
 *
 * @author Kevin
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {

    public static CommandInvoker getInstance() {
        if(instance == null) {
            instance = new CommandInvoker();
        }

        return instance;
    }

    private static CommandInvoker instance;

    private Map<Integer, Command> commands = new HashMap<>();

    private CommandInvoker() {
        commands.put(0, new SignUp());
        commands.put(1, new SignIn());
        commands.put(2, new UpdateProfile());
        commands.put(3, new AddContact());
        commands.put(4, new RemoveContact());
    }

    public void execute(Socket conn) throws IOException {
        BufferedReader in = null;
        String option = null;
        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            option = in.readLine();
        } catch (IOException e) {
            System.out.println("I/O error on creating socket");
            e.printStackTrace();
        } 
        System.out.println(option);
        Command comm = commands.get(Integer.parseInt(option)).clonar();
        comm.execute(conn, in);
    }

}
