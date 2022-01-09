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

//    public ChildOfEmployee(String name, String surname, LocalDate dateOfBirth, List<Employee> employee) {
//        this.name = name;
//        this.surname = surname;
//        this.dateOfBirth = dateOfBirth;
//        this.employee = employee;
//    }
}
