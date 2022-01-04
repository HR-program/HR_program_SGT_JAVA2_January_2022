package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "positions")
public class PositionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(name = "employee_work_start_date")
    private LocalDate workStartDate;

    @Column(name = "employee_work_end_date")
    private LocalDate workEndDate;
}
