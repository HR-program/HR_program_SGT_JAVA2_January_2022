package lv.hr.program.model;

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
//            (fetch = FetchType.LAZY)
////            (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
////    @JoinColumn(name = "employee_id")
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

//    @Column(name = "child_age")
//    private int getAgeOfChild(LocalDate childDateOfBirth, LocalDate currentDate){
//
//
//            return Period.between(childDateOfBirth,currentDate).getYears();}

//        public int calculateAge(
//                LocalDate birthDate,
//                LocalDate currentDate) {
//            // validate inputs ...
//            return Period.between(birthDate, currentDate).getYears();

//    @ManyToMany(mappedBy = "childrenOfEmployee",
//            fetch = FetchType.LAZY)
//    private List<Employee> employees;

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
