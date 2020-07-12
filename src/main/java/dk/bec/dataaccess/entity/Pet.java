package dk.bec.dataaccess.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PETS")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME", length = 70, nullable = false)
    private String name;

    @Column(name="BIRTH_NAME")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    // constructors, getters and setters below

    public Pet() {}

    public Pet(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setFirstName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
