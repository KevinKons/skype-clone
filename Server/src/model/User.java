package model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_tb")
public class User implements Serializable {

    @Column(name = "ip")
    private String ip;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Id
    private String nickname;
    
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Column(name = "status", nullable = false, length = 100)
    private String status;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="user_contact",
            joinColumns = {@JoinColumn(name="id_user")},
            inverseJoinColumns = {@JoinColumn(name="id_contact")})
    private List<User> contacts = new ArrayList<>();

    public User() {}

    public User(String nickname, String password, String name, String status) {
        this.nickname = nickname;
        this.password = password;
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
    
     public void addContact(User contact) {
        this.contacts.add(contact);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void removeContact(User contact) {
        this.contacts.remove(contact);
    }

}
