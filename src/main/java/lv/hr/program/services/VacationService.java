package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Vacation;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VacationService {

    List<Vacation> getAllVacation();

    Vacation addNewVacation(Vacation vacation);

    Iterable <Vacation> getVacationByEmployeesID(Long id);
}
