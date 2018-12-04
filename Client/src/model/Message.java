package model;

public class Message {

    private final String content;
    private final String sender;

    public Message(String content, String nickname){
        this.content = content;
        this.sender = nickname;
    }

    public String getContent() {
        return content;
    }
}
