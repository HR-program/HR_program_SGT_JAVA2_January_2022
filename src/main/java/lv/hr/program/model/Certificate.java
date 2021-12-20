package lv.hr.program.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private long id;

    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_issue")
    private Calendar dateOfIssue;

    @Column(name = "date_of_expiry")
    private Calendar dateOfExpiry;
}
