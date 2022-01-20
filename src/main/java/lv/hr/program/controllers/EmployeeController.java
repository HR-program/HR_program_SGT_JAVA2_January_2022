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

    //    @GetMapping("/employees")
//    public Iterable<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees() {
//        Employee employee = new Employee();
//        List<Employee> employeeList = new ArrayList<>();
//        employee.getName();
//        employee.getSurname();
//        employee.getGender();
//        employee.getDateOfBirth();
//        employee.getPersonalCode();
//        employee.getIdDocumentNumber();
//        employee.getIdDocumentExpiryDate();
//        employee.getPhoneNumber();
//        employee.getEmail();
//        employee.getAddress();
//        employee.getEducation();
//        employee.getDepartment();
//        employee.isDoesEmployeeHaveChild();
//        employee.isEmployeeActive();
//        employeeList.add(employee);
//        return (List<Employee>) employeeService.getAllEmployees();
//    }

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

//    @GetMapping("/employees/active")
//    public Iterable<Employee> getAllActiveEmployees() {
//        return employeeService.getAllActiveEmployees();
//    }

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

//    @PostMapping("/employees")
//    public void addNewEmployee(@RequestBody Employee employee) {
//
//        employee.setName(employee.getName());
//        employee.setSurname(employee.getSurname());
//        employee.setGender(employee.getGender());
//        employee.setDateOfBirth(employee.getDateOfBirth());
//        employee.setPersonalCode(employee.getPersonalCode());
//        employee.setIdDocumentNumber(employee.getIdDocumentNumber());
//        employee.setIdDocumentExpiryDate(employee.getIdDocumentExpiryDate());
//        employee.setPhoneNumber(employee.getPhoneNumber());
//        employee.setEmail(employee.getEmail());
//        employee.setAddress(employee.getAddress());
//        employee.setEducation(employee.getEducation());
//        employee.setDepartment(employee.getDepartment());
//        employee.setDoesEmployeeHaveChild(employee.setHavingChildrenToFalse());
//        employee.setEmployeeActive(employee.isEmployeeActive());
//        employee.setWorkStartDate(employee.getWorkStartDate());
//        employeeService.create(employee);
//    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        try {
            Employee employeeSaved = employeeService.create(employee);
            return new ResponseEntity<>(employeeSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/employees/{id}")
//    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
//        return employeeService.update(id, employee);
//    }

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

//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") Long id) {
//        try {
//            employeeService.deleteEmployeeByID(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/employees/department/{id}")
    public Iterable<Employee> getEmployeesByDepartmentID(@PathVariable("id") Long id) {
        return employeeService.getEmployeesByDepartmentId(id);
    }

    @GetMapping("/employees/personal-code/{personal-code}")
    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(@PathVariable("personal-code") String personalCode) {
        return employeeService.fetchEmployeeByPersonalCodeLike(personalCode);
    }

//    @GetMapping("/employees/personal-code/{personal-code}")
//    public ResponseEntity<Employee> findByPersonalCodeLike(@RequestParam String personalCode) {
//        Optional<Employee> employeeData = employeeService.findEmployeeByPersonalCodeLike(personalCode);
//
//        if (employeeData.isPresent()) {
//            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long Id) {
        return employeeService.fetchEmployeeByID(Id);
    }

//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> findById(@PathVariable("id") long id) {
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

    @GetMapping("/employees/name/{name}")
    public Iterable<Employee> fetchEmployeeByNameLike(@PathVariable String name) {
        return employeeService.fetchEmployeeByNameLikeIgnoreCase(name);
    }

    //    @GetMapping("/employees/name/{name}")
//    public ResponseEntity<Iterable<Employee>> findByNameLike(@RequestParam String name) {
//        Optional<Iterable<Employee>> employeeData = Optional.ofNullable(employeeService.fetchEmployeeByNameLikeIgnoreCase(name));
//
//        if (employeeData.isPresent()) {
//            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/employees/surname/{surname}")
    public Iterable<Employee> fetchEmployeeBySurnameLike(@PathVariable String surname) {
        return employeeService.fetchEmployeeBySurnameLikeIgnoreCase(surname);
    }

//    @GetMapping("/employees/surname/{surname}")
//    public ResponseEntity<Iterable<Employee>> findBySurnameLike(@RequestParam String surname) {
//        Optional<Iterable<Employee>> employeeData = Optional.ofNullable(employeeService.fetchEmployeeBySurnameLikeIgnoreCase("%" + surname + "%"));
//
//        if (employeeData.isPresent()) {
//            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
