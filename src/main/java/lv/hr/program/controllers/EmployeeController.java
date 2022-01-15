package lv.hr.program.controllers;

import lombok.RequiredArgsConstructor;
import lv.hr.program.model.Department;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import lv.hr.program.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")//standard(api/v1) url endpoint used for apis

public class EmployeeController {

    private EmployeeService employeeService;

    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

//    @GetMapping("/employees")
//    public ResponseEntity<Iterable<Employee>> getAllEmployees(@RequestParam(required = false) String surname) {
//        try {
//            List<Employee> employees = new ArrayList<Employee>();
//
//            if (surname == null) {
//                employeeRepository.findAll().forEach(employees::add);
//            } else {
//                employeeService.fetchEmployeeBySurnameLikeIgnoreCase(surname).forEach(employees::add);
//            }
//
//            if (employees.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(employees, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/employees/active")
    public Iterable<Employee> getAllActiveEmployees() {
        return employeeService.getAllActiveEmployees();
    }

    @GetMapping("/employees/department/{id}")
    public Iterable<Employee> getEmployeesByDepartmentID(@PathVariable("id") Long id) {
        return employeeService.getEmployeesByDepartmentId(id);
    }

    @PostMapping("/employees")
//    @ApiOperation("adding new employee to database")
    public void addNewEmployee(@RequestBody Employee employee) {
//department.addEmployee(employee);
        employeeService.create(employee);
    }

//    @PostMapping("/employees")
//    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
//        try {
//            Employee _employee = employeeRepository
//                    .save(new Employee(employee.getWorkStartDate(), employee.getWorkEndDate(), employee.getName(), employee.getSurname(), employee.getGender(),
//                            employee.getDateOfBirth(), employee.getPersonalCode(), employee.getIdDocumentNumber(),
//                            employee.getIdDocumentExpiryDate(), employee.getPhoneNumber(), employee.getEmail(),
//                            employee.getAddress(), employee.getEducation(), employee.isEmployeeActive()));
//            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
//        Optional<Employee> employeeData = employeeRepository.findById(id);
//
//        if (employeeData.isPresent()) {
//            Employee _employee = employeeData.get();
//            _employee.setWorkStartDate(employee.getWorkStartDate());
//            _employee.setWorkEndDate(employee.getWorkEndDate());
//            _employee.setName(employee.getName());
//            _employee.setSurname(employee.getSurname());
//            _employee.setGender(employee.getGender());
//            _employee.setDateOfBirth(employee.getDateOfBirth());
//            _employee.setPersonalCode(employee.getPersonalCode());
//            _employee.setIdDocumentNumber(employee.getIdDocumentNumber());
//            _employee.setIdDocumentExpiryDate(employee.getIdDocumentExpiryDate());
//            _employee.setPhoneNumber(employee.getPhoneNumber());
//            _employee.setEmail(employee.getEmail());
//            _employee.setAddress(employee.getAddress());
//            _employee.setEducation(employee.getEducation());
//            _employee.setDepartment(employee.getDepartment());
//            _employee.setCurrentPosition(employee.getCurrentPosition());
//            _employee.setCertificate(employee.getCertificate());
//            _employee.setEvaluation(employee.getEvaluation());
//            _employee.setVacation(employee.getVacation());
//            _employee.setDoesEmployeeHaveChild(employee.isDoesEmployeeHaveChild());
//            _employee.setChildOfEmployee(employee.getChildOfEmployee());
//            _employee.setEmployeeActive(employee.isEmployeeActive());
//
//            return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long Id) {
        employeeService.deleteEmployeeByID(Id);
    }

//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") Long id) {
//        try {
//            employeeService.deleteEmployeeByID(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

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
    public Employee fetchEmployeeById(@PathVariable("id") Long Id) {
        return employeeService.fetchEmployeeByID(Id);
    }

//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> fetchEmployeeById(@PathVariable("id") Long id) {
//        Optional<Employee> employeeData = employeeRepository.findById(id);
//
//        if (employeeData.isPresent()) {
//            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/employees/sort-by-name")
    public Iterable<Employee> sortAllEmployeesByName() {
        return employeeService.sortAllEmployeesByName();
    }

    @GetMapping("/employees/sort-by-surname")
    public Iterable<Employee> sortAllEmployeesBySurname() {
        return employeeService.sortAllEmployeesBySurname();
    }
}
