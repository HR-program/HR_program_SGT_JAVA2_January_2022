package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_surname")
    private String surname;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "employee_date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "employee_personal_code")
    private String personalCode;

    @Column(name = "employee_id_document_number")
    private String idDocumentNumber;

    @Column(name = "employee_id_document_expiry_date")
    private LocalDate idDocumentExpiryDate;

    @Column(name = "phone_number")
    private String phoneNumber;
    // System.out.println(String.valueOf(phoneNum).replaceFirst("(\\d{3})(\\d{2})(\\d{3})(\\d+)", "($1)$2-$3-$4"));

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "employee_education")
    private String education;

    @ManyToOne

    private Department department;


//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//
////            referencedColumnName = "current_position")
//    private List<PositionHistory> currentPosition;

//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
////            referencedColumnName = "certificates")
//    private List<Certificate> certificate;

//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
////            referencedColumnName = "evaluation")
//    private List<Evaluation> evaluation;

    @OneToMany
//            (fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
////            referencedColumnName = "vacation")
    (mappedBy = "employee")
    private List<Vacation> vacation;

    @Column(name = "employee_has_a_child")
    private boolean doesEmployeeHaveChild;

//@OneToMany
////        (fetch = FetchType.EAGER)
////        (mappedBy = "employee")
////(fetch = FetchType.EAGER, orphanRemoval = true)
//    private List<ChildOfEmployee> childOfEmployee;

    @Column(name = "employee_is_active_worker")
    private boolean employeeActive;

    public Employee() {
    }

    public Employee(long id, String name, String surname, Gender gender, LocalDate dateOfBirth, String personalCode, String idDocumentNumber, LocalDate idDocumentExpiryDate, String phoneNumber, String email, String address, String education, Department department, boolean doesEmployeeHaveChild, List<ChildOfEmployee> childOfEmployee, boolean employeeActive) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.personalCode = personalCode;
        this.idDocumentNumber = idDocumentNumber;
        this.idDocumentExpiryDate = idDocumentExpiryDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.education = education;
        this.department = department;
        this.doesEmployeeHaveChild = doesEmployeeHaveChild;
//        this.childOfEmployee = childOfEmployee;
        this.employeeActive = employeeActive;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getIdDocumentNumber() {
        return idDocumentNumber;
    }

    public void setIdDocumentNumber(String idDocumentNumber) {
        this.idDocumentNumber = idDocumentNumber;
    }

    public LocalDate getIdDocumentExpiryDate() {
        return idDocumentExpiryDate;
    }

    public void setIdDocumentExpiryDate(LocalDate idDocumentExpiryDate) {
        this.idDocumentExpiryDate = idDocumentExpiryDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public List<PositionHistory> getCurrentPosition() {
//        return currentPosition;
//    }
//
//    public void setCurrentPosition(List<PositionHistory> currentPosition) {
//        this.currentPosition = currentPosition;
//    }
//
//    public List<Certificate> getCertificate() {
//        return certificate;
//    }
//
//    public void setCertificate(List<Certificate> certificate) {
//        this.certificate = certificate;
//    }
//
//    public List<Evaluation> getEvaluation() {
//        return evaluation;
//    }
//
//    public void setEvaluation(List<Evaluation> evaluation) {
//        this.evaluation = evaluation;
//    }

    public List<Vacation> getVacation() {
        return vacation;
    }

    public void setVacation(List<Vacation> vacation) {
        this.vacation = vacation;
    }

        public boolean isDoesEmployeeHaveChild () {
            return doesEmployeeHaveChild;
        }

        public void setDoesEmployeeHaveChild ( boolean doesEmployeeHaveChild){
            this.doesEmployeeHaveChild = doesEmployeeHaveChild;
        }

//    public List<ChildOfEmployee> getChildOfEmployee() {
//        return childOfEmployee;
//    }
//
//    public void setChildOfEmployee(List<ChildOfEmployee> childOfEmployee) {
//        this.childOfEmployee = childOfEmployee;
//    }

        public boolean isEmployeeActive () {
            return employeeActive;
        }

        public void setEmployeeActive ( boolean employeeActive){
            this.employeeActive = employeeActive;
        }

        // all arguments' constructor
        // standard getters and setters
    }

