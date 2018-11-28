package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String nickname;
    private String password;
    private boolean online;
    private String ip;
    private String status;
    private List<User> contacts = new ArrayList<>();
    private List<Chat> chats = new ArrayList<>();

    public User(String name, String nickname, String password, boolean online, String ip, String status, List<User> contacts) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.online = online;
        this.ip = ip;
        this.status = status;
        this.contacts = contacts;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }
}
