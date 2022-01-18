package lv.hr.program.services;

import lv.hr.program.model.Vacation;
import lv.hr.program.repositories.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @Override
    public Vacation addNewVacation(Vacation vacation) {
        vacationRepository.save(vacation);
        return vacation;
    }

//    @Override
//    public int countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(LocalDate workStartDate, LocalDate currentDate) {
//        //" > 0" if workStartDate is after currentDate.minus(Period.ofDays(365))
//        if (workStartDate.compareTo(currentDate.minus(Period.ofDays(365))) > 0) {
//            int daysBetween = (int) DAYS.between(workStartDate, currentDate);
//            int vacationDays = (int) ((daysBetween / 30) * 1.67);
//            return vacationDays;
//        } //" < 0" if workStartDate is before currentDate.minus(Period.ofDays(365))
//        else if (workStartDate.compareTo(currentDate.minus(Period.ofDays(365))) <= 0) {
//            LocalDate dateBeforeYear = currentDate.minus(Period.ofDays(365));
//            int daysBetween = (int) DAYS.between(dateBeforeYear, currentDate);
//            int vacationDays = (int) (daysBetween / 30 * 1.67);
//            return vacationDays;
//        } else {
//            return 0;
//        }
//    }

//    @Override
//    public HashMap<Integer, Integer> returnCalculatedVacationDaysForAllYears(LocalDate workStartYear, LocalDate workCurrentYear) {
////        Vacation vacation = new Vacation();
//        HashMap<Integer, Integer> vacationDays = new HashMap<>();
//        int counter = 0;
//        if (workStartYear.compareTo(workCurrentYear) <= 0) {
//            for (int i = 0; counter <= (workCurrentYear.getYear() - workStartYear.getYear()); i++) {
//                int vacationDaysDuringYear = vacationService.
//                        countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(workStartYear, workCurrentYear);
//                vacationDays.put(workStartYear.getYear(), vacationDaysDuringYear);
//                counter++;
//            }
//        } else {
//            vacationDays.put(workStartYear.getYear(), 0);
//        }
//        return vacationDays;
//    }
}
