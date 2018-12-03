/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.chat.SendMessageToClient;
import controller.contacts.AddContact;
import controller.contacts.ControllerContacts;
import controller.contacts.RemoveContact;
import java.util.ArrayList;
import java.util.List;
import model.Chat;
import model.User;

/**
 *
 * @author dougl
 */
public class ControllerHome implements Observed {

    private List<ObserverHome> observers = new ArrayList<>();
    private User contactActive;
    private SendMessageToClient sendMessageToClient;

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
            boolean ip = false;
            if (contact.getIp() == null) {
                ip = true;
            }
            for (ObserverHome obs : observers) {
                obs.showContact(contact.getNickname(), contact.getName(), contact.getStatus(), ip);
            }
        }
    }

    public void removeContact(String nickname) {
        ControllerContacts controllerContacts = new ControllerContacts();
        try {
            controllerContacts.executeStrategy(new RemoveContact(), nickname);
            alert("Usuário: " + nickname + " removido da sua lista de contatos");
        } catch (Exception e) {
            alert(e.getMessage());
        }
    }

    public void openChat(String nickname) {

        String messages = "";

        for (User contact : ManageControllers.getInstance().getUser().getContacts()) {
            if (contact.getNickname().equalsIgnoreCase(nickname)) {
                contactActive = contact;
                if (ManageControllers.getInstance().getUser().getChats() != null) {
                    for (Chat chat : ManageControllers.getInstance().getUser().getChats()) {
                        messages += chat.getAllMessages();
                    }
                    showMessages(messages);
                    System.out.println("Chat carregados: [" + messages + "].");
                } else {
                    Chat chat = new Chat(nickname, "");
                    ManageControllers.getInstance().getUser().addChat(chat);
                }
            }
        }

    }

    public void sendMessageToClient(String message) {
        sendMessageToClient = new SendMessageToClient(message, contactActive.getIp(), contactActive.getNickname());
        sendMessageToClient.start();
    }

    private void showMessages(String messages) {
        for (ObserverHome obs : observers) {
            obs.showMessages(messages);
        }
    }

}
