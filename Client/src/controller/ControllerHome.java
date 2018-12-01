/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.contacts.AddContact;
import controller.contacts.ControllerContacts;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dougl
 */
public class ControllerHome implements Observed {

    private List<ObserverHome> observers = new ArrayList<>();

    public void addContact(String nickname) {
        ControllerContacts controllerContacts = new ControllerContacts();
        try {
            controllerContacts.executeStrategy(new AddContact(), nickname);
        } catch (Exception e) {
            alert(e.getMessage());
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

    private void setNameNavBar() {
        System.out.println("Observers: " + observers.size());
        for (ObserverHome obs : observers) {
            obs.setNameNavBar(ManageControllers.getInstance().getUser().getName());
        }
    }

}
