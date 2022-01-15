package lv.hr.program.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "child_personal_code")
    private String personalCode;

    public ChildOfEmployee(String name, String surname, LocalDate dateOfBirth, String personalCode) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.personalCode = personalCode;
    }

    @ManyToMany(mappedBy = "childrenOfEmployee",
            fetch = FetchType.LAZY)
    private List<Employee> employee;
}
