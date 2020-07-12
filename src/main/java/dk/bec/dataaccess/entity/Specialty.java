package dk.bec.dataaccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SPECIALTIES")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME", length = 70, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "specialties")
    private List<Vet> vets;

    // constructors,  getters and setters below

    public Specialty() {}

    public Specialty(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Vet> getVetInternal() {
        if (this.vets == null) {
            this.vets = new ArrayList<>();
        }
        return this.vets;
    }

    public List<Vet> getVets() {
        return getVetInternal();
    }

    public void addVet(Vet vet) {
        vet.addSpecialty(this);
        this.getVetInternal().add(vet);
    }

    public void setVets(List<Vet> vets) {
        this.vets = vets;
    }
}
