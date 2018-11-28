package com.udesc.skypeclone.server.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chat_tb")
public class Chat implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "chat_owner")
    private User owner;

    @Column(name = "other")
    private String nickmane;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "messages")
    private List<Message> messages = new ArrayList<>();

    public Chat() {  }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getNickmane() {
        return nickmane;
    }

    public void setNickmane(String nickmane) {
        this.nickmane = nickmane;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
