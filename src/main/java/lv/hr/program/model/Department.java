package lv.hr.program.model;

import javax.persistence.*;

@Entity
@Table (name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "department_address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "employee_id",
            insertable = false,
            updatable = false,
            nullable = false)
    private Employee employee;

    public Department() {
    }

    public Department(String name, String address, Employee employee) {
        this.name = name;
        this.address = address;
        this.employee = employee;
    }
}
