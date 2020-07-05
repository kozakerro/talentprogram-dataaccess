package dk.bec.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCID", nullable = false)
    private int id;

    @Column(name = "BANK", length = 50)
    private String bank;

    @Column(name = "ACCOUNT_NUMBER", length = 40)
    private String number;

    // One-To-One Bi-Directional
    @OneToOne(mappedBy = "account")
    private Employee employee;

    public Account() {}

    public Account(String bank, String number) {
        this.bank = bank;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // One-To-One Bi-Directional
    public Employee getEmployee() {
        return employee;
    }

    // One-To-One Bi-Directional
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
