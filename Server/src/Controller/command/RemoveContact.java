package Controller.command;

import DAO.UserDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.persistence.NoResultException;
import model.User;
import util.CloseConnection;

/**
 *
 * @author Kevin
 */
public class RemoveContact implements Command {

    @Override
    public void execute(Socket conn, BufferedReader in) throws IOException {
        PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
        // nickname
        try {
            System.out.println(conn.getInetAddress().getHostAddress());
            User user = UserDAO.findByIp(conn.getInetAddress().getHostAddress());
            User contact = UserDAO.findByNickname(in.readLine());
            
            user.removeContact(contact);
            
            UserDAO.editar(user);
            
            System.out.println(user.getName() + " excluiu " + contact.getName() + " da sua lista de contatos.");
            out.println(1);
        } catch(NoResultException ex) {
            out.println("0");
        } finally {
            CloseConnection.getInstance().close(in, out, conn);
        }
    }

    @Override
    public Command clonar() {
        return new RemoveContact();
    }
    
}
