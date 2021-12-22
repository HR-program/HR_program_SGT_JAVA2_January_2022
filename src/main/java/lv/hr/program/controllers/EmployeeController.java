package lv.hr.program.controllers;

import lv.hr.program.model.Employee;
import lv.hr.program.services.EmployeeService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/")//standard(api/v1) url endpoint used for apis
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//get all Employees

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

//  add new employee

    @PostMapping("/employees")
//    @ApiOperation("adding new employee to database")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable("id") Long Id, @RequestBody Employee employee) {
        employeeService.update(Id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long Id) {
        employeeService.deleteEmployeeByID(Id);
    }

    @GetMapping("/employees/id-number/{id-number}")
    public Employee fetchEmployeeByIdNumber(@PathVariable("id-number") String idNumber) {
        return employeeService.fetchEmployeeByIdNumber(idNumber);
    }
    @GetMapping("/employees/surname/{surname}")
    public Iterable<Employee> fetchEmployeeBySurname(@PathVariable String surname){
        return employeeService.fetchEmployeeBySurname(surname);
    }
}

