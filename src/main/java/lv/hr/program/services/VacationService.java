package lv.hr.program.services;

import lv.hr.program.model.Vacation;

import java.time.LocalDate;

public interface VacationService {

    Vacation create(Vacation vacation);

//    List<LocalDate> countBusinessDaysBetweenEmployeeStartWorkDateAndCurrentDate(final LocalDate startDate,
//                                                                                final LocalDate endDate,
//                                                                                final Optional<List<LocalDate>> holidays);

//    int countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(LocalDate dateBefore, LocalDate dateAfter);
}
