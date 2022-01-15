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
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long id;

    @Column(name = "work_start_date")
    private LocalDate workStartDate;

    @Column(name = "work_end_date")
    private LocalDate workEndDate;

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

    public Employee(LocalDate workStartDate, LocalDate workEndDate, String name, String surname, Gender gender,
                    LocalDate dateOfBirth, String personalCode, String idDocumentNumber, LocalDate idDocumentExpiryDate,
                    String phoneNumber, String email, String address, String education, boolean employeeActive) {
        this.workStartDate = workStartDate;
        this.workEndDate = workEndDate;
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
        this.employeeActive = employeeActive;
    }

    public Employee(LocalDate workStartDate, LocalDate workEndDate, String name, String surname, Gender gender,
                    LocalDate dateOfBirth, String personalCode, String idDocumentNumber, LocalDate idDocumentExpiryDate,
                    String phoneNumber, String email, String address, String education,
                    List<Department> department, boolean employeeActive) {
        this.workStartDate = workStartDate;
        this.workEndDate = workEndDate;
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
        this.employeeActive = employeeActive;
    }

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Department> department;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<PositionHistory> currentPosition;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Certificate> certificate;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Evaluation> evaluation;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Vacation> vacation;

    @Column(name = "employee_has_a_child")
    private boolean doesEmployeeHaveChild;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "employee_children",
            joinColumns = {
                    @JoinColumn(name = "employee_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "child_id",
                            nullable = false, updatable = false)})
    private List<ChildOfEmployee> childrenOfEmployee;

    @Column(name = "employee_is_active_worker")
    private boolean employeeActive;
}