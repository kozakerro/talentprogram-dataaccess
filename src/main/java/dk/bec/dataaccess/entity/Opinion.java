package dk.bec.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "OPINIONS")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "OPINION_TEXT", length = 1000, nullable = false)
    private String opinionText;

    // constructors, getters and setters below

    public Opinion() {}

    public Opinion(String opinionText) {
        this.opinionText = opinionText;
    }

    public int getId() {
        return id;
    }

    public String getOpinionText() {
        return opinionText;
    }

    public void setOpinionText(String opinionText) {
        this.opinionText = opinionText;
    }
}
