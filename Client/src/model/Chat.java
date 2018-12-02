package model;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private List<Message> messages = new ArrayList<>();
    private String nickname;

    public Chat(String nickname, String message) {
        this.nickname = nickname;
        this.messages.add(new Message(message));
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

    public void addMenssage(String message) {
        this.messages.add(new Message(message));
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
