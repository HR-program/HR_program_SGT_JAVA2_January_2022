package lv.hr.program.controllers;

import lv.hr.program.model.Employee;
import lv.hr.program.model.Vacation;
import lv.hr.program.services.EmployeeService;
import lv.hr.program.services.VacationService;
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
        public Iterable<Vacation> getVacationByEmployeesID(@PathVariable("id") Long id) {
            return vacationService.getVacationByEmployeesID(id);
        }
    }
