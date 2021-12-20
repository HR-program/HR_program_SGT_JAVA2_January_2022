package lv.hr.program.model;

import javax.persistence.*;
import java.util.Calendar;
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

    @Column(name = "employee_date_of_birth")
    private Calendar dateOfBirth;

    @Column(name = "employee_id_number")
    private String idNumber;

    @Column(name = "employee_id_document_number")
    private String idDocumentNumber;

    @Column(name = "employee_id_document_expiry_date")
    private Calendar idDocumentExpiryDate;

    @Column(name = "phone_number")
    private String phoneNumber;
    // System.out.println(String.valueOf(phoneNum).replaceFirst("(\\d{3})(\\d{2})(\\d{3})(\\d+)", "($1)$2-$3-$4"));

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "employee_education")
    private String education;

    @Column(name = "employee_department_name")
    private Department department;

    @Column(name = "employee_position")
    private PositionHistory currentPosition;

    @Column(name = "employee_certificate")
    private String certificate;

    @Column(name = "evaluation")
    private Evaluation evaluation;

    @Column(name = "vacation")
    private Vacation vacation;

    @Column(name = "employee_has_a_child")
    private boolean doesEmployeeHaveChild;

    @Column(name = "employee_date_of_birth")
    private List<ChildOfEmployee> childOfEmployee;

    @Column(name = "employee_is_active_worker")
    private boolean isEmployeeActive;

    // all arguments' constructor
    // standard getters and setters
}
