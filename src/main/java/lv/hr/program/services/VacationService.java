package lv.hr.program.services;

import lv.hr.program.model.Vacation;

import java.util.List;

public interface VacationService {

    List<Vacation> getAllVacation();

    Vacation addNewVacation(Vacation vacation);

    Iterable <Vacation> getVacationByEmployeesID(Long id);
}
