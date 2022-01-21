package lv.hr.program.controllers;

import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import lv.hr.program.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")//standard(api/v1) url endpoint used for apis

public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        try {
            if (employeeService.getAllEmployees().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/active")
    public ResponseEntity<Iterable<Employee>> getAllActiveEmployees() {
        try {
            if (employeeService.getAllActiveEmployees().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employeeService.getAllActiveEmployees(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        try {
            Employee employeeSaved = employeeService.create(employee);
            return new ResponseEntity<>(employeeSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeRepository.findById(id);

        if (employeeData.isPresent()) {
            Employee employeeToBeUpdated = employeeData.get();
            employeeToBeUpdated.setWorkStartDate(employee.getWorkStartDate());
            employeeToBeUpdated.setWorkEndDate(employee.getWorkEndDate());
            employeeToBeUpdated.setName(employee.getName());
            employeeToBeUpdated.setSurname(employee.getSurname());
            employeeToBeUpdated.setGender(employee.getGender());
            employeeToBeUpdated.setDateOfBirth(employee.getDateOfBirth());
            employeeToBeUpdated.setPersonalCode(employee.getPersonalCode());
            employeeToBeUpdated.setIdDocumentNumber(employee.getIdDocumentNumber());
            employeeToBeUpdated.setIdDocumentExpiryDate(employee.getIdDocumentExpiryDate());
            employeeToBeUpdated.setPhoneNumber(employee.getPhoneNumber());
            employeeToBeUpdated.setEmail(employee.getEmail());
            employeeToBeUpdated.setAddress(employee.getAddress());
            employeeToBeUpdated.setEducation(employee.getEducation());
            employeeToBeUpdated.setDepartment(employee.getDepartment());
            employeeToBeUpdated.setCertificate(employee.getCertificate());
            employeeToBeUpdated.setDoesEmployeeHaveChild(employee.isDoesEmployeeHaveChild());
            employeeToBeUpdated.setEmployeeActive(employee.isEmployeeActive());
            return new ResponseEntity<>(employeeRepository.save(employeeToBeUpdated), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long Id) {
        employeeService.deleteEmployeeByID(Id);
    }

    @GetMapping("/employees/department/{id}")
    public Iterable<Employee> getEmployeesByDepartmentID(@PathVariable("id") Long id) {
        return employeeService.getEmployeesByDepartmentId(id);
    }

    @GetMapping("/employees/personal-code/{personal-code}")
    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(@PathVariable("personal-code") String personalCode) {
        return employeeService.fetchEmployeeByPersonalCodeLike(personalCode);
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long Id) {
        return employeeService.fetchEmployeeByID(Id);
    }

    @GetMapping("/employees/active/sort-by-name")
    public Iterable<Employee> getAllActiveEmployeesAndSortByName() {
        return employeeService.getAllActiveEmployeesAndSortByName();
    }

    @GetMapping("/employees/active/sort-by-surname")
    public Iterable<Employee> getAllActiveEmployeesAndSortBySurname() {
        return employeeService.getAllActiveEmployeesAndSortBySurname();
    }

    @GetMapping("/employees/sort-by-name")
    public Iterable<Employee> sortAllEmployeesByName() {
        return employeeService.sortAllEmployeesByName();
    }

    @GetMapping("/employees/sort-by-surname")
    public Iterable<Employee> sortAllEmployeesBySurname() {
        return employeeService.sortAllEmployeesBySurname();
    }

    @GetMapping("/employees/name/{name}")
    public Iterable<Employee> fetchEmployeeByNameLike(@PathVariable String name) {
        return employeeService.fetchEmployeeByNameLikeIgnoreCase(name);
    }

    @GetMapping("/employees/surname/{surname}")
    public Iterable<Employee> fetchEmployeeBySurnameLike(@PathVariable String surname) {
        return employeeService.fetchEmployeeBySurnameLikeIgnoreCase(surname);
    }
}
