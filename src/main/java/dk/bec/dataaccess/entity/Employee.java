package dk.bec.dataaccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPID", nullable = false, unique = true)
    private int id;

    @Column(name = "FIRST_NAME", length = 70)
    private String firstName;

    @Column(name="LAST_NAME", length = 70)
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Computer> computers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="ASSESSMENT_ID")
    private List<Assessment> assessments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "EMPLOYEE_PROJECT",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    private List<Project> projects;

    public Employee() {}

    public Employee(String firstName, String lastName) {
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
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addComputer(Computer computer) {
        if (computers == null) {
            computers = new ArrayList<>();
        }
        // bi-directional reference
        computers.add(computer);
        computer.setEmployee(this);
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void addAssessment(Assessment assessment) {
        if (assessments == null) {
            assessments = new ArrayList<>();
        }

        assessments.add(assessment);
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        if (this.projects==null) {
            this.projects = new ArrayList<>();
        }
        project.addEmployee(this);
        this.projects.add(project);
    }
}
