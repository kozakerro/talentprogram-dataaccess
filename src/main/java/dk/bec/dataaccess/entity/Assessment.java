package dk.bec.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "ASSESSMENT")
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ASSID", nullable = false)
    private int id;

    @Column(name = "GRADE", nullable = false)
    private int grade;

    @Column(name = "JUSTIFICATION", length = 500)
    private String justification;

    public Assessment() {}

    public Assessment(int grade, String justification) {
        this.grade = grade;
        this.justification = justification;
    }

    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }
}
