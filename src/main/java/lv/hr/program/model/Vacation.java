package lv.hr.program.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private long id;

    @Column(name = "vacation_days")
    private int vacationDays;

    @OneToOne
    private Employee employee;

    public Vacation() {
    }

    public Vacation(int vacationDays, Employee employee) {
        this.vacationDays = vacationDays;
        this.employee = employee;
    }

    public Vacation(long id, int vacationDays, Employee employee) {
        this.id = id;
        this.vacationDays = vacationDays;
        this.employee = employee;
    }

    public int countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(LocalDate workStartDate, LocalDate currentDate) {
        //" > 0" if workStartDate is after currentDate.minus(Period.ofDays(365))
        if (workStartDate.compareTo(currentDate.minus(Period.ofDays(365))) > 0) {
            int daysBetween = (int) DAYS.between(workStartDate, currentDate);
            int vacationDays = (int) ((daysBetween / 30) * 1.67);
            return vacationDays;
        } //" < 0" if workStartDate is before currentDate.minus(Period.ofDays(365))
        else if (workStartDate.compareTo(currentDate.minus(Period.ofDays(365))) <= 0) {
            LocalDate dateBeforeYear = currentDate.minus(Period.ofDays(365));
            int daysBetween = (int) DAYS.between(dateBeforeYear, currentDate);
            int vacationDays = (int) (daysBetween / 30 * 1.67);
            return vacationDays;
        } else {
            return 0;
        }
    }

    public HashMap<Integer, Integer> returnCalculatedVacationDaysForAllYears(LocalDate workStartYear, LocalDate workCurrentYear) {
        Vacation vacation = new Vacation();
        HashMap<Integer, Integer> vacationDays = new HashMap<>();
        int counter = 0;
        if (workStartYear.compareTo(workCurrentYear) <= 0) {
            for (int i = 0; counter <= (workCurrentYear.getYear() - workStartYear.getYear()); i++) {
                int vacationDaysDuringYear = vacation.
                        countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(workStartYear, workCurrentYear);
                vacationDays.put(workStartYear.getYear(), vacationDaysDuringYear);
                counter++;
            }
        } else {
            vacationDays.put(workStartYear.getYear(), 0);
        }
        return vacationDays;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
