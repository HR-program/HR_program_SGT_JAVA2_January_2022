package lv.hr.program.controllers;

import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import lv.hr.program.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")//standard(api/v1) url endpoint used for apis
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
//    @ApiOperation("adding new employee to database")
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

//    @PostMapping("/employees")
//    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
//        try {
//            Employee _employee = employeeRepository
//                    .save(new Employee(employee.getId(), employee.getName(), employee.getSurname(), employee.getGender(),
//                            employee.getDateOfBirth(), employee.getPersonalCode(), employee.getIdDocumentNumber(),
//                            employee.getIdDocumentExpiryDate(), employee.getPhoneNumber(), employee.getEmail(),
//                            employee.getAddress(), employee.getEducation(), employee.getDepartment(),
//                            employee.getCurrentPosition(), employee.getCertificate(), employee.getEvaluation(),
//                            employee.getVacation(), employee.isDoesEmployeeHaveChild(), employee.getChildrenOfEmployee(),
//                            employee.isEmployeeActive()));
//            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PutMapping("/employees/{id}")
//    public void updateEmployee(@PathVariable("id") Long Id, @RequestBody Employee employee) {
//        employeeService.update(Id, employee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public void deleteEmployeeById(@PathVariable("id") Long Id) {
//        employeeService.deleteEmployeeByID(Id);
//    }

//    @GetMapping("/employees/id-number/{id-number}")
//    public Employee fetchEmployeeByIdNumber(@PathVariable("id-number") String idNumber) {
//        return employeeService.fetchEmployeeByIdNumber(idNumber);
//    }
//    @GetMapping("/employees/surname/{surname}")
//    public Iterable<Employee> fetchEmployeeBySurname(@PathVariable String surname){
//        return employeeService.fetchEmployeeBySurname(surname);
//    }
    @GetMapping("/employees/surname/{surname}")
    public Iterable<Employee> fetchEmployeeBySurnameLike(@PathVariable String surname){
        return employeeService.fetchEmployeeBySurnameLike("%"+surname+"%");
    }
    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long Id){
        return employeeService.fetchEmployeeByID(Id);
    }
    @GetMapping("/employees/sort-by-name")
    public Iterable<Employee> sortAllEmployeesByName() {
        return employeeService.sortAllEmployeesByName();
    }
    @GetMapping("/employees/sort-by-surname")
    public Iterable<Employee> sortAllEmployeesBySurname() {
        return employeeService.sortAllEmployeesBySurname();
    }

}

