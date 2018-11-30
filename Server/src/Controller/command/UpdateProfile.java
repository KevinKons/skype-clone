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
public class UpdateProfile implements Command {
    
    @Override
    public void execute(Socket conn, BufferedReader in) throws IOException {
        String[] info = in.readLine().split(";");
        User user = UserDAO.findByNickname(info[0]);
        user.setName(info[1]);
        user.setStatus(info[2]);
        UserDAO.editar(user);
        
        PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
        out.println("1");
        CloseConnection.getInstance().close(in, out, conn);
    }

    @Override
    public Command clonar() {
        return new UpdateProfile();
    }
    
}
