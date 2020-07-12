package dk.bec.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "OWNERS")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWNERID", nullable = false, unique = true)
    private int id;

    @Column(name = "FIRST_NAME", length = 70, nullable = false)
    private String firstName;

    @Column(name="LAST_NAME", length = 70, nullable = false)
    private String lastName;

    @Column(name="ADDRESS", length = 255)
    private String address;

    @Column(name="CITY", length = 80, nullable = false)
    private String city;

    @Column(name="TELEPHONE", length = 20, nullable = false)
    private String telephone;

    // constructors, getters and setters below

    public Owner() {}

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Owner(String firstName, String lastName, String city, String telephone) {
        this(firstName, lastName);
        this.city = city;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String city) {
        this.city = city;
    }

}
