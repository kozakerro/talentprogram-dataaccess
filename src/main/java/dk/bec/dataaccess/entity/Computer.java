package dk.bec.dataaccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "COMPUTER")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPID", nullable = false)
    private int id;

    @Column(name = "MANUFACTURER", length = 70)
    private String manufacturer;

    @Column(name = "MODEL", length = 20)
    private String model;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public Computer() {}

    public Computer(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
