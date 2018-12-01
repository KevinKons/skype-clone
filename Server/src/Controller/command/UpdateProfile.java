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
        // nickname ; name ; status
        String[] info = in.readLine().split(";");
        User user = UserDAO.findByNickname(info[0]);
        user.setName(info[1]);
        user.setStatus(info[2]);
        
        PrintWriter out = null;
        try {
            UserDAO.editar(user);
            out = new PrintWriter(conn.getOutputStream(), true);
            out.println("1");
            System.out.println(user.getName() + " atualizou seu perfil.");
            CloseConnection.getInstance().close(in, out, conn);
        } catch(Exception ex) {
            out.println(0);
        }
    }

    @Override
    public Command clonar() {
        return new UpdateProfile();
    }
    
}
