package model;

import controller.ObserverHome;
import controller.authentication.Observed;
import controller.authentication.Observer;
import java.util.ArrayList;
import java.util.List;

public class User implements Observed {

    private String ip;
    private String name;
    private String nickname;
    private String password;
    private String status;
    private List<Chat> chats = new ArrayList<>();
    private List<User> contacts = new ArrayList<>();

    private List<ObserverHome> observers = new ArrayList<>();

    public User() {
    }

    public User(String name, String nickname, String password, String status) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.status = status;
    }

    public User(String nickname, String name, String status) {
        this.nickname = nickname;
        this.name = name;
        this.status = status;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getContacts() {
        return contacts;
    }

    public void setContacts(List<User> contacts) {
        this.contacts = contacts;
    }

    public void setContact(User contact) {
        this.contacts.add(contact);
    }

    public void addContact(User contact) {
        this.contacts.add(contact);
        for (ObserverHome o : this.observers) {
            o.notifiesUserAdded(contact.getNickname(), contact.getName(),
                    contact.getStatus(), contact.getIp());
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public void addChat(Chat chat) {
        for(ObserverHome obs: observers){
            obs.clearTextArea();
        }
        this.chats.add(chat);
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add((ObserverHome) obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public String toString() {
        return "User{" + "ip=" + ip + ", name=" + name + ", nickname=" + nickname + ", password=" + password + ", status=" + status + ", chats=" + chats + ", contacts=" + contacts + ", observers=" + observers + '}';
    }

}
