package controller;

import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ControllerAuthentication implements Observed {

    //Socket
    private Socket conn;
    private String address;
    private int port;

    private MaintainOnline maintainOnline;
    private ManageControllers manageControllers = ManageControllers.getInstance();
    private List<Observer> observers = new ArrayList<>();

    public ControllerAuthentication(String address, int port) {
        this.address = address;
        this.port = port;
    }

    @Override
    public void signUp(String name, String nickname, String password, String repeatPassword) {

        if (!password.equalsIgnoreCase(repeatPassword)) {
            alert("Senhas não conferem!");
        } else {
            PrintWriter out = null;
            BufferedReader in;
            try {
                System.out.println("Abrindo socket");
                //Envia uma requisição para realizar o cadastro do Usuário
                conn = new Socket(this.address, this.port);
                System.out.println("abaixo do socket");
                out = new PrintWriter(conn.getOutputStream(), true);
                out.println(0);
                //nickname name password status
                String message = nickname + ";" + name + ";" + password + ";" + "Hey, i'm using Skype-Clone!";
                out.println(message);
                System.out.println("enivou user");
                
                //Espera uma resposta
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                //Armazena a resposta do backend
                int answer = Integer.parseInt(in.readLine());

                //Verifica se o cadastro foi realizado com sucesso
                if (answer == 0) {
                    alert("Não foi possível realizar o cadastro");
                } else {
                    alert("Cadastro realizado com sucesso!");
                }

            } catch (IOException e) {                
                alert("Erro!\n\n" + e.getMessage());
            }
        }
    }

    public User signIn(String nickname, String password) {

        try {
            conn = new Socket(this.address, this.port);

            //Envia uma requisição para realizar o Login
            PrintWriter out = new PrintWriter(conn.getOutputStream(), true);
            out.println(1);
            String message = nickname + ";" + password;
            out.println(message);

            //Recebe o User
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String answer = in.readLine();

            try {
                int content = Integer.parseInt(answer);
                alert("Usuário ou senha incorretos");
            } catch (NumberFormatException e) {
                
                //nickname name status
                String data[] = answer.split(";");

                User user = new User(data[1], data[0], "", data[2]);
                String contact;

                while ((contact = in.readLine()) != null) {

                    String[] contactInfo = contact.split(";");

                    User oContact = new User(contactInfo[1], contactInfo[0], "", contactInfo[2]);
                    oContact.setIp(contactInfo[3]);

                    user.addContacts(oContact);
                }

                //Armazena o usuário autenticado no ManageControllers e 
                //inicia os serviços
                manageControllers.setUser(user);
                manageControllers.initControllers();
                
                alert("Login realizado com sucesso!");
                
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

    private void startMaintainOnline() {
        maintainOnline.start();
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    private void alert(String message) {
        for (Observer obs : observers) {
            obs.alert(message);
        }
    }

}
