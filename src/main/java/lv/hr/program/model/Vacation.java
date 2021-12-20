package lv.hr.program.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private long id;

    @Column(name = "year")
    private Calendar year;

    @Column(name = "vacation_start_date")
    private Calendar vacationStartDate;

    @Column(name = "vacation_end_date")
    private Calendar vacationEndDate;

    @Column (name = "vacation_days_for_child")
    private int vacationDaysForChild;

    @Column (name = "vacation_days_for_work_experience")
    private int vacationDaysForWorkExperience;
}
