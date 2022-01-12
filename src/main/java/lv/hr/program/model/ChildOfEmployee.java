package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "child")
public class ChildOfEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private long childId;

    @Column(name = "child_personal_code")
    private String childPersonalCode;

    @Column(name = "child_date_of_birth")
    private Date childDateOfBirth;

    @Column(name = "child_name")
    private String childName;

    @Column(name = "child_surname")
    private String childSurname;
//    @ManyToOne
//            (fetch = FetchType.LAZY)
////            (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
////    @JoinColumn(name = "employee_id")
//
//    private Employee employee;

    public long getChildId() {
        return childId;
    }

    public void setChildId(long childId) {
        this.childId = childId;
    }

    public String getChildPersonalCode() {
        return childPersonalCode;
    }

    public void setChildPersonalCode(String childPersonalCode) {
        this.childPersonalCode = childPersonalCode;
    }

    public Date getChildDateOfBirth() {
        return childDateOfBirth;
    }

    public void setChildDateOfBirth(Date childDateOfBirth) {
        this.childDateOfBirth = childDateOfBirth;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildSurname() {
        return childSurname;
    }

    public void setChildSurname(String childSurname) {
        this.childSurname = childSurname;
    }

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public ChildOfEmployee() {

    }

    }
