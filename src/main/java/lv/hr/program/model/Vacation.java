package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private long id;

    @Column(name = "year")
    private int year;
    // int year = Year.now().getValue();
    // int year = ZonedDateTime.now(ZoneId.of("Africa/Casablanca")).getYear();

    @Column(name = "vacation_start_date")
    private LocalDate vacationStartDate;

    @Column(name = "vacation_end_date")
    private LocalDate vacationEndDate;

    @Column(name = "vacation_days_for_child")
    private int vacationDaysForChild;

    @Column(name = "vacation_days_for_work_experience")
    private int vacationDaysForWorkExperience;
}
