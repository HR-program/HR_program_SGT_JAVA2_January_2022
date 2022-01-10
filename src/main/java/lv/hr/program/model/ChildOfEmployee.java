package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "child")
public class ChildOfEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private long id;

    @Column(name = "child_name")
    private String name;

    @Column(name = "child_surname")
    private String surname;

    @Column(name = "child_date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "childrenOfEmployee",
            fetch = FetchType.LAZY)
    private List<Employee> employee;

    public ChildOfEmployee() {
    }

    public ChildOfEmployee(String name, String surname, LocalDate dateOfBirth, List<Employee> employee) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
