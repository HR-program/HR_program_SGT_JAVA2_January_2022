package lv.hr.program.controllers;

import lombok.RequiredArgsConstructor;
import lv.hr.program.model.Employee;
import lv.hr.program.model.Vacation;
import lv.hr.program.repositories.VacationRepository;
import lv.hr.program.services.VacationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class VacationController {

    private final VacationService vacationService;
    private final VacationRepository vacationRepository;
    private final Employee employee;
    private final LocalDate currentDate;

    @PostMapping("/vacation")
    public ResponseEntity<Vacation> addVacation(@RequestBody Vacation vacation) {
        try {
            Vacation _vacation = vacationRepository
                    .save(new Vacation(vacation.getYear(), vacation.getVacationStartDate(),
                            vacation.getVacationEndDate(), vacation.getVacationDaysForChild(),
                            vacation.getVacationDaysForWorkExperience()));
            return new ResponseEntity<>(_vacation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/vacation/count-worked-business-days")
//    public ResponseEntity<Vacation> showBusinessDaysBetweenEmployeeStartWorkDateAndCurrentDate
//            (@RequestBody Vacation vacation) {
//
//
//         Optional<Vacation> vacationData = vacationService.countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(employee.getWorkStartDate(), currentDate);
//
//            if (vacationData.isPresent()) {
//                return new ResponseEntity<>(vacationData.get(), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//    }
}