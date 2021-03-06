package lv.hr.program.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "child")
public class ChildOfEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private long childId;

    @Column(name = "child_personal_code")
    private String childPersonalCode;

    @Column(name = "child_date_of_birth")
    private LocalDate childDateOfBirth;

    @Column(name = "child_name")
    private String childName;

    @Column(name = "child_surname")
    private String childSurname;

    @ManyToOne
    private Employee employee;

    @Column(name = "child_age")
    private int ageOfChild;

    public ChildOfEmployee() {
    }

    public ChildOfEmployee(long childId, String childPersonalCode, LocalDate childDateOfBirth, String childName, String childSurname, Employee employee) {
        this.childId = childId;
        this.childPersonalCode = childPersonalCode;
        this.childDateOfBirth = childDateOfBirth;
        this.childName = childName;
        this.childSurname = childSurname;
        this.employee = employee;
    }

    public ChildOfEmployee(long childId, String childPersonalCode, LocalDate childDateOfBirth, String childName, String childSurname, Employee employee, int ageOfChild) {
        this.childId = childId;
        this.childPersonalCode = childPersonalCode;
        this.childDateOfBirth = childDateOfBirth;
        this.childName = childName;
        this.childSurname = childSurname;
        this.employee = employee;
        this.ageOfChild = ageOfChild;
    }

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

    public LocalDate getChildDateOfBirth() {
        return childDateOfBirth;
    }

    public void setChildDateOfBirth(LocalDate childDateOfBirth) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getAgeOfChild() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(childDateOfBirth, currentDate).getYears();
    }

    public void setAgeOfChild(int ageOfChild) {
        this.ageOfChild = ageOfChild;
    }
}
