package lv.hr.program.controllers;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import lv.hr.program.model.Vacation;
//import lv.hr.program.services.VacationService;
import lv.hr.program.services.EmployeeService;
import lv.hr.program.services.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/")
public class VacationController {

    private VacationService vacationService;
    private EmployeeService employeeService;

    public VacationController(VacationService vacationService, EmployeeService employeeService) {
        this.vacationService = vacationService;
        this.employeeService = employeeService;
    }

//    @PostMapping("/vacation/employee/{id}")
//    public void returnCalculatedVacationDaysForAllYears(@RequestBody Vacation vacation,
//                                                        @PathVariable("id") Long id) {
//        Employee employee = new Employee();
//        employee = employeeService.fetchEmployeeByID(id);
//        int countedVacationDays = vacation
//                .countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(employee.getWorkStartDate(), LocalDate.now());
//        vacation.setVacationDays(countedVacationDays);
//        vacation.setEmployee(employee);
//        vacationService.addNewVacation(vacation);
//    }

    @PostMapping("/vacation/employee/{id}")
    public ResponseEntity<Vacation> returnCalculatedVacationDaysForAllYears(@RequestBody Vacation vacation,
                                                                            @PathVariable("id") Long id) {
        try {
            Employee employee = new Employee();
            employee = employeeService.fetchEmployeeByID(id);
            int countedVacationDays = vacation
                    .countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(employee.getWorkStartDate(), LocalDate.now());
            vacation.setVacationDays(countedVacationDays);
            vacation.setEmployee(employee);
            vacationService.addNewVacation(vacation);
            return new ResponseEntity<>(vacation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vacation/employee/{id}")
    public ResponseEntity<Iterable<Vacation>> getVacationByEmployeesID(@PathVariable("id") Long id) {
        try {
            if (vacationService.getAllVacation().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(vacationService.getAllVacation(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
