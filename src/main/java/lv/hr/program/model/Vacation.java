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

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "employee_id",
            insertable = false,
            updatable = false,
            nullable = false)
    private Employee employee;

    public Vacation() {
    }

    public Vacation(int year, LocalDate vacationStartDate, LocalDate vacationEndDate, int vacationDaysForChild, int vacationDaysForWorkExperience, Employee employee) {
        this.year = year;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
        this.vacationDaysForChild = vacationDaysForChild;
        this.vacationDaysForWorkExperience = vacationDaysForWorkExperience;
        this.employee = employee;
    }
}
