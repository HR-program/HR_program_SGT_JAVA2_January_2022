package lv.hr.program.controllers;

import lombok.RequiredArgsConstructor;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import lv.hr.program.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> getAllEmployees(@RequestParam(required = false) String surname) {
        try {
            List<Employee> employees = new ArrayList<Employee>();

            if (surname == null) {
                employeeRepository.findAll().forEach(employees::add);
            } else {
                employeeService.findBySurnameLike(surname).forEach(employees::add);
            }

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee = employeeRepository
                    .save(new Employee(employee.getName(), employee.getSurname(), employee.getGender(),
                            employee.getDateOfBirth(), employee.getPersonalCode(), employee.getIdDocumentNumber(),
                            employee.getIdDocumentExpiryDate(), employee.getPhoneNumber(), employee.getEmail(),
                            employee.getAddress(), employee.getEducation(), employee.isEmployeeActive()));
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Optional<Employee> employeeData = employeeRepository.findById(id);

        if (employeeData.isPresent()) {
            Employee _employee = employeeData.get();
            _employee.setName(employee.getName());
            _employee.setSurname(employee.getSurname());
            _employee.setGender(employee.getGender());
            _employee.setDateOfBirth(employee.getDateOfBirth());
            _employee.setPersonalCode(employee.getPersonalCode());
            _employee.setIdDocumentNumber(employee.getIdDocumentNumber());
            _employee.setIdDocumentExpiryDate(employee.getIdDocumentExpiryDate());
            _employee.setPhoneNumber(employee.getPhoneNumber());
            _employee.setEmail(employee.getEmail());
            _employee.setAddress(employee.getAddress());
            _employee.setEducation(employee.getEducation());
            _employee.setDepartment(employee.getDepartment());
            _employee.setCurrentPosition(employee.getCurrentPosition());
            _employee.setCertificate(employee.getCertificate());
            _employee.setEvaluation(employee.getEvaluation());
            _employee.setVacation(employee.getVacation());
            _employee.setDoesEmployeeHaveChild(employee.isDoesEmployeeHaveChild());
            _employee.setChildrenOfEmployee(employee.getChildrenOfEmployee());
            _employee.setEmployeeActive(employee.isEmployeeActive());

            return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("id") Long id) {
        try {
            employeeService.deleteEmployeeByID(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/sort-by-name")
    public Iterable<Employee> sortAllEmployeesByName() {
        return employeeService.sortAllEmployeesByName();
    }

    @GetMapping("/employees/sort-by-surname")
    public Iterable<Employee> sortAllEmployeesBySurname() {
        return employeeService.sortAllEmployeesBySurname();
    }


//    @GetMapping("/employees/{id}")
//    public Optional<Employee> findEmployeeById(@PathVariable("id") Long id){
//        return employeeRepository.findById(id);
//    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") long id) {
        Optional<Employee> employeeData = employeeRepository.findById(id);

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/employees/personal-code/{personal-code}")
    public ResponseEntity<Employee> findByPersonalCode(@RequestParam String personalCode) {
        Optional<Employee> employeeData = employeeRepository.findByPersonalCode(personalCode);

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/employees/surname/{surname}")
//    public Iterable<Employee> fetchEmployeeBySurname(@PathVariable String surname){
//        return employeeRepository.findBySurname(surname);
//    }

    @GetMapping("/employees/name/{name}")
    public ResponseEntity<Iterable<Employee>> findByNameLike(@RequestParam String name) {
        Optional<Iterable<Employee>> employeeData = Optional.ofNullable(employeeService.findByNameLike(name));

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("/employees/surname/{surname}")
//    public ResponseEntity<Iterable<Employee>> fetchEmployeeBySurname(@PathVariable String surname) {
//        Optional<Iterable<Employee>> employeeData = Optional.ofNullable(employeeRepository.findBySurname(surname));
//
//        if (employeeData.isPresent()) {
//            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//        @GetMapping("/employees/surname/{surname}")
//        public Iterable<Employee> findBySurnameLike(@PathVariable String surname){
//            return employeeService.findBySurnameLike("%" + surname + "%");
//        }

    @GetMapping("/employees/surname/{surname}")
    public ResponseEntity<Iterable<Employee>> findBySurnameLike(@RequestParam String surname) {
        Optional<Iterable<Employee>> employeeData = Optional.ofNullable(employeeService.findBySurnameLike("%" + surname + "%"));

        if (employeeData.isPresent()) {
            return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
