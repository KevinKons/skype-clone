import model.User;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        User user = new User("Douglas", "doug", "senha123", true, "10.60.92.204", "Hey, este é um status", new ArrayList<>());
        Socket conn = null;
        PrintWriter out = null;
        try {
            conn = new Socket("10.60.94.208", 56000);
            ObjectOutputStream oOut = new ObjectOutputStream(conn.getOutputStream());
            //Envia uma requisição para realizar o cadastro do Usuário
            out = new PrintWriter(conn.getOutputStream(), true);
            out.println(0);
//            String message = 0 + "," + user.getName() + "," + user.getNickname() + "," + user.getPassword() + "," + user.getOnline() + "," + user.getIp() + "," + user.getStatus();
            oOut.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert out != null;
            out.close();
        }

    }

}
