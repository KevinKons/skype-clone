package Controller.command;

import DAO.UserDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import model.User;
import util.CloseConnection;

/**
 *
 * @author Kevin
 */
public class SignUp implements Command {

    @Override
    public void execute(Socket conn, BufferedReader in) throws IOException {
//      nickname ; password, ; name ; status
        String[] info = in.readLine().split(";");
        PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
        
        User user = new User(info[0], info[1], info[2], info[3]);
        try {
            UserDAO.salvar(user);
            out.println(1);
            
            System.out.println(user.getNickname() + " Signed up");
        } catch(Exception ex) {
            out.println(0);
        }
        
        CloseConnection.getInstance().close(in, out, conn);
    }

    @Override
    public Command clonar() {
        return new SignUp();
    }
    
}
