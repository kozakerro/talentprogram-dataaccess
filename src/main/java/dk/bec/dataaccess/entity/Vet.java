package dk.bec.dataaccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VETS")
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "FIRST_NAME", length = 70, nullable = false)
    private String firstName;

    @Column(name="LAST_NAME", length = 70, nullable = false)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "VET_ID")
    private List<Opinion> opinions;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(name = "VET_SPECIALTIES",
        joinColumns = @JoinColumn(name = "VET_ID"),
        inverseJoinColumns = @JoinColumn(name = "SPECIALTY_ID")
    )
    private List<Specialty> specialties;

    // constructors and other getters, setters here

    public Vet() {}

    public Vet(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private List<Opinion> getOpinionsInternal() {
        if (this.opinions == null) {
            this.opinions = new ArrayList<>();
        }
        return opinions;
    }

    public void addOpinion(Opinion opinion) {
        getOpinionsInternal().add(opinion);
    }

    public List<Opinion> getOpinions() {
        return getOpinionsInternal();
    }

    private List<Specialty> getSpecialtiesInternal() {
        if (this.specialties == null) {
            this.specialties = new ArrayList<>();
        }
        return specialties;
    }

    public void addSpecialty(Specialty specialty) {
        getSpecialtiesInternal().add(specialty);
    }

    public List<Specialty> getSpecialties() {
        return getSpecialtiesInternal();
    }

}
