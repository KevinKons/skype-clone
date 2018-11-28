package com.udesc.skypeclone.server.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "message_tb")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "content", nullable = false, length = 200)
    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender")
    private User sender;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    public Message() {
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setContent(String content) {
        this.content = content;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getSender() {
        return sender;
    }

    public LocalDate getData() {
        return data;
    }
}
