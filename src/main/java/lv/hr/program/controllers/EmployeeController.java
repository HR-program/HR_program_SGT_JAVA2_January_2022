package lv.hr.program.controllers;

import lv.hr.program.model.Department;
import lv.hr.program.model.Employee;
import lv.hr.program.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")//standard(api/v1) url endpoint used for apis

public class EmployeeController {
@Autowired
    private EmployeeService employeeService;



    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
//get all Employees
    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/active")
    public Iterable<Employee> getAllActiveEmployees() {
        return employeeService.getAllActiveEmployees();
    }

    @GetMapping("/employees/department/{id}")
    public Iterable<Employee> getEmployeesByDepartmentID(@PathVariable("id") Long id){
        return employeeService.getEmployeesByDepartmentId(id);
    }

//  add new employee
    @PostMapping("/employees")
//    @ApiOperation("adding new employee to database")
    public void addNewEmployee(@RequestBody Employee employee) {

//department.addEmployee(employee);
        employeeService.create(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {

        return employeeService.update(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long Id) {
        employeeService.deleteEmployeeByID(Id);
    }

    @GetMapping("/employees/personal-code/{personal-code}")
    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(@PathVariable("personal-code") String personalCode) {
        return employeeService.fetchEmployeeByPersonalCodeLike(personalCode);
    }
    @GetMapping("/employees/surname/{surname}")
    public Iterable<Employee> fetchEmployeeBySurnameLike(@PathVariable String surname) {
        return employeeService.fetchEmployeeBySurnameLikeIgnoreCase(surname);
    }

    @GetMapping("/employees/name/{name}")
    public Iterable<Employee> fetchEmployeeByNameLike(@PathVariable String name) {
        return employeeService.fetchEmployeeByNameLikeIgnoreCase(name);
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

