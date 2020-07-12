package dk.bec.dataaccess.entity;

import sun.security.provider.MD5;
import sun.security.rsa.RSASignature;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "LOGIN", length = 100, nullable = false, unique = true)
    private String login;

    @Column(name="PASSWORD_HASH", length = 300, nullable = false)
    private String passwordHash;

    @Column(name="ACTIVE", nullable = false)
    private boolean active;

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    @OneToOne(mappedBy = "account")
    private Vet vet;

    public Account() {}

    public Account(String login, String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.active = false;
    }

    // getters and setters below

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

}
