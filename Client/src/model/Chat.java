package model;

import controller.Observed;
import controller.ObserverHome;
import controller.authentication.Observer;
import java.util.ArrayList;
import java.util.List;

public class Chat implements Observed {

    private List<ObserverHome> observers = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();
    private String nickname;
    
    public Chat(){}
    
    public Chat(String nickname, String message) {
        this.nickname = nickname;
        this.messages.add(new Message(message, nickname));
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getAllMessages() {
        String allMessages = "";
        for (Message message : messages) {
            allMessages += message.getContent() + "\n\n";
        }
        return allMessages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMenssage(String message, String nickname) {
        this.messages.add(new Message(message, nickname));
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public void addObserver(ObserverHome obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(ObserverHome obs) {
        observers.add(obs);
    }
}
