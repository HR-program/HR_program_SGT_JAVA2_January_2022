package lv.hr.program.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            optional = false)
//    @JoinColumn(name = "employee_id",
//            insertable = false,
//            updatable = false,
//            nullable = false)
//    private Employee employee;

//    @ManyToMany(mappedBy = "childrenOfEmployee",
//            fetch = FetchType.LAZY)
//    private List<Employee> employee;
}
