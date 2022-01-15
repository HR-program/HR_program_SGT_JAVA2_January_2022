package lv.hr.program.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class Department<cascade> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "department_address")
    private String address;

    public Department(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @OneToMany
//            (mappedBy = "department")
    private List<Employee> employeeArrayList = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY,
//            optional = false)
//    @JoinColumn(name = "employee_id",
//            insertable = false,
//            updatable = false,
//            nullable = false)
//    private Employee employee;
}
