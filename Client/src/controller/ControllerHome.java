/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.chat.Call;
import controller.chat.SendMessage;
import controller.contacts.AddContact;
import controller.contacts.ControllerContacts;
import controller.contacts.RecorderThread;
import controller.contacts.RemoveContact;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import model.Chat;
import model.Message;
import model.User;

/**
 *
 * @author dougl
 */
public class ControllerHome implements Observed {

    private List<ObserverHome> observers = new ArrayList<>();
    private String nicknameContact;
    private SendMessage sendMessageToClient;
    private Call call;

    public void addContact(String nickname) {
        if (nickname != null) {
            ControllerContacts controllerContacts = new ControllerContacts();
            try {
                controllerContacts.executeStrategy(new AddContact(), nickname);
            } catch (Exception e) {
                alert(e.getMessage());
            }
        }
    }

    @Override
    public void addObserver(ObserverHome obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(ObserverHome obs) {
        observers.remove(obs);
    }

    private void alert(String message) {
        for (ObserverHome obs : observers) {
            obs.alert(message);
        }
    }

    public void showContacts() {
        for (User contact : ManageControllers.getInstance().getUser().getContacts()) {
            for (ObserverHome obs : observers) {
                obs.notifiesUserAdded(contact.getNickname(), contact.getName(),
                        contact.getStatus(), contact.getIp());
            }
        }
    }

    public void removeContact(String nickname) {
        ControllerContacts controllerContacts = new ControllerContacts();
        try {
            controllerContacts.executeStrategy(new RemoveContact(), nickname);
            for (ObserverHome obs : observers) {
                System.out.println("Entrou na lista de observados do removeContact");
                obs.notifiesUserRemove(nickname);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            alert(e.getMessage());
        }
    }

    public void openChat(String nickname) {
        
        this.nicknameContact = nickname;

        String messages = "";
        User user = ManageControllers.getInstance().getUser();

        if (user.getChats() != null) {
            for (Chat chat : user.getChats()) {
                if (chat.getNickname().equals(nickname)) {
                    for (Message message : chat.getMessages()) {
                        messages += message.getSender() + ": "
                                + message.getContent() + "\n";
                    }
                    
                    showMessage(messages);
                    break;
                }
            }
        } else {
            Chat chat = new Chat(nickname, "");
            user.addChat(chat);
        }

    }

    public void sendMessage(String message) {
        sendMessageToClient = new SendMessage(message, nicknameContact);
        sendMessageToClient.start();
    }
    
    public void call() {
        Socket conn = null;
        PrintWriter out = null;
        
        String ip = "";
        User user = ManageControllers.getInstance().getUser();
        
        for(User contact : user.getContacts()) {
            if(contact.getNickname().equals(nicknameContact)) 
                ip = contact.getIp();
        }
        
        try {
           conn = new Socket(ip, 56004);
           out = new PrintWriter(conn.getOutputStream(), true);
           
           out.println(0);
           out.println(user.getNickname());
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    private void showMessage(String messages) {
        for (ObserverHome obs : observers) {
            obs.addMessage(messages);
        }
    }
    
    public void acceptCall(String nickname, String ip) {
        Socket conn = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
           conn = new Socket(ip, 56004);
           out = new PrintWriter(conn.getOutputStream(), true);
           in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           
           out.println(1);
           out.println(nickname + ";" + ip);
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
    }

    public void initCall(TargetDataLine audioIn, SourceDataLine audioOut, String ip) {
        call = new Call(audioIn, audioOut, ip);
        call.initRecorder();
        call.initPlayer();
    }


}
