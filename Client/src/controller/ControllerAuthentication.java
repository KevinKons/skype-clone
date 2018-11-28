package controller;

import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ControllerAuthentication {

    //Socket
    private Socket conn;
    private String address;
    private int port;

    private MaintainOnline maintainOnline;
    private ManageControllers manageControllers = ManageControllers.getInstance();

    public ControllerAuthentication(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public User login(String nickname, String password) {

        try {
            conn = new Socket(this.address, this.port);

            //Envia uma requisição para realizar o Login
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            String message = 1 + "," + nickname + "," + password;
            out.println(message);

            //Recebe um objeto User
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String answer = in.readLine();

            if (!answer.equalsIgnoreCase("null")) {

                String data[] = answer.split(",");
//                manageControllers.setUser(new User(data[0], data[1], data[2], Boolean.parseBoolean(data[3]), data[4], data[5], new ArrayList<>()));
                manageControllers.initControllers();

            } else {
                System.out.println("Informações incorretas");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void signUp(User user) {
        PrintWriter out = null;
        try {
            //Envia uma requisição para realizar o cadastro do Usuário
            out = new PrintWriter(conn.getOutputStream(), true);
//            String message = 0 + "," + user.getName() + "," + user.getNickname() + "," + user.getPassword() + "," + user.getOnline() + "," + user.getIp() + "," + user.getStatus();
//            out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert out != null;
            out.close();
        }
    }

    private void startMaintainOnline() {
        maintainOnline.start();
    }

}
