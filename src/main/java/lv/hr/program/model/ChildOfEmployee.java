package lv.hr.program.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "child")
public class ChildOfEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private long childId;

    @Column(name = "child_name")
    private String childName;

    @Column(name = "child_surname")
    private String childSurname;

    @Column(name = "child_date_of_birth")
//    @Temporal(TemporalType.DATE)
    private LocalDate childDateOfBirth;

    @Column(name = "child_personal_code")
    private String childPersonalCode;

    public ChildOfEmployee(String childName, String childSurname, LocalDate childDateOfBirth, String childPersonalCode) {
        this.childName = childName;
        this.childSurname = childSurname;
        this.childDateOfBirth = childDateOfBirth;
        this.childPersonalCode = childPersonalCode;
    }

    @ManyToOne
//            (fetch = FetchType.LAZY)
//            (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
    private Employee employee;

//    @ManyToMany(mappedBy = "childrenOfEmployee",
//            fetch = FetchType.LAZY)
//    private List<Employee> employees;
}
