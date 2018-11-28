package Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_tb")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "nickname", nullable = false, length = 15)
    private String nickname;
    
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    @Transient
    private boolean online;

    @Column(name = "status", nullable = false, length = 100)
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="user_contact",
            joinColumns = {@JoinColumn(name="id_user")},
            inverseJoinColumns = {@JoinColumn(name="id_contact")})
    private List<User> contacts = new ArrayList<>();

    public User() {}

    public User(String ip, String name, String nickname, String status) {
        this.ip = ip;
        this.name = name;
        this.nickname = nickname;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
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
    
     public void addContacts(User contact) {
        this.contacts.add(contact);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     
     
    
    
}
