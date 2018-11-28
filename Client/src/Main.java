import model.User;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        User user = new User("10.60.92.204", "Douglas", "doug", "Hey, este é um status");
        Socket conn = null;
        PrintWriter out = null;
        try {
            System.out.println("Tentando conectar...");
            conn = new Socket("10.60.94.208", 56000);
            System.out.println("Conectou!");
            ObjectOutputStream oOut = new ObjectOutputStream(conn.getOutputStream());
            //Envia uma requisição para realizar o cadastro do Usuário
            out = new PrintWriter(conn.getOutputStream(), true);
            out.println(0);
            System.out.println("Enviou o codigo");
//            String message = 0 + "," + user.getName() + "," + user.getNickname() + "," + user.getPassword() + "," + user.getOnline() + "," + user.getIp() + "," + user.getStatus();
            oOut.writeObject(user);
            System.out.println("Enviou o objeto");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
