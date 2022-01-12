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

//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
//    private List<Department> department;

//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
//    private List<PositionHistory> currentPosition;
//
//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
//    private List<Certificate> certificate;
//
//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
//    private List<Evaluation> evaluation;
//
//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
//    private List<Vacation> vacation;
//
//    @Column(name = "employee_has_a_child")
//    private boolean doesEmployeeHaveChild;
//
//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
//    private List<ChildOfEmployee> childrenOfEmployee;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "employee_children",
//            joinColumns = {
//                    @JoinColumn(name = "employee_id",
//                            referencedColumnName = "child_id",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "child_id",
//                            referencedColumnName = "employee_id",
//                            nullable = false, updatable = false)})
//    private List<ChildOfEmployee> childrenOfEmployee;

    @Column(name = "employee_is_active_worker")
    private boolean employeeActive;

}