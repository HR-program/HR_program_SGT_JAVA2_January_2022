package lv.hr.program.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "positions")
public class PositionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(name = "employee_work_start_date")
    private Calendar workStartDate;

    @Column(name = "employee_work_end_date")
    private Calendar workEndDate;
}
