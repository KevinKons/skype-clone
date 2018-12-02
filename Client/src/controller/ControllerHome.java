/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.contacts.AddContact;
import controller.contacts.ControllerContacts;
import controller.contacts.RemoveContact;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author dougl
 */
public class ControllerHome implements Observed {

    private List<ObserverHome> observers = new ArrayList<>();

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
                obs.showContact(contact.getNickname(), contact.getName(), contact.getStatus());
            }
        }
    }

    public void removeContact(String nickname) {
        ControllerContacts controllerContacts = new ControllerContacts();
        try {
            controllerContacts.executeStrategy(new RemoveContact(), nickname);
            System.out.println("Removeu:" + nickname);
        } catch (Exception e) {
            alert(e.getMessage());
        }
    }

}
