/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.chat.SendMessage;
import controller.contacts.AddContact;
import controller.contacts.ControllerContacts;
import controller.contacts.RemoveContact;
import java.util.ArrayList;
import java.util.List;
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
    
//    public void call

    private void showMessage(String messages) {
        for (ObserverHome obs : observers) {
            obs.addMessage(messages);
        }
    }


}
