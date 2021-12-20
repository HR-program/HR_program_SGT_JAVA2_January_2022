package lv.hr.program.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table (name = "child")
public class ChildOfEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private long id;

    @Column(name = "child_name")
    private String name;

    @Column(name = "child_surname")
    private String surname;

    @Column(name = "child_date_of_birth")
    private Calendar dateOfBirth;

}
