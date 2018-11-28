package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenMessages extends Thread {

    private ServerSocket serverSocket;

    @Override
    public void run() {

        try {
            serverSocket = new ServerSocket(56001);
            serverSocket.setReuseAddress(true);

            while(true){

                System.out.println("Waiting connection");
                Socket conn = serverSocket.accept();

                try {

                    //Getting the message
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    Object message = in.readLine();

                    //Locating the sender through of IP
                    String ip = conn.getLocalSocketAddress().toString();

                    //Insert the message in Chat with the sender


                } catch(IOException e){

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
