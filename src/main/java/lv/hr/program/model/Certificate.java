package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private long id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;

    @Column(name = "date_of_expiry")
    private LocalDate dateOfExpiry;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "employee_id",
            insertable = false,
            updatable = false,
            nullable = false)
    private Employee employee;

    public Certificate() {
    }

    public Certificate(String number, String name, LocalDate dateOfIssue, LocalDate dateOfExpiry, Employee employee) {
        this.number = number;
        this.name = name;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiry = dateOfExpiry;
        this.employee = employee;
    }
}
