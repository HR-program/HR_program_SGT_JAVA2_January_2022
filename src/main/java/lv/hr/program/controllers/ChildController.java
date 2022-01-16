package lv.hr.program.controllers;


import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.ChildRepository;
import lv.hr.program.services.ChildService;
import lv.hr.program.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/")
public class ChildController {

    private ChildService childService;
    private EmployeeService employeeService;
    private ChildRepository childRepository;

    public ChildController(ChildService childService, EmployeeService employeeService, ChildRepository childRepository) {
        this.childService = childService;
        this.employeeService = employeeService;
        this.childRepository = childRepository;
    }


        @GetMapping("/children/employee/{id}")
    public Iterable<ChildOfEmployee>findByEmployeesID(@PathVariable("id") Long id){return childService.findByEmployeeId(id);}

    @GetMapping("/children")
    public List<ChildOfEmployee> getAllChildren() {
        return childService.getAllChildren();
    }

    @PostMapping("/children")
    public ResponseEntity<ChildOfEmployee> addNewChild(@RequestBody ChildOfEmployee childOfEmployee) {
        try {
            ChildOfEmployee childOfEmployeeSaved = childService.addNewChild(childOfEmployee);

            return new ResponseEntity<>(childOfEmployeeSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/children/employee/{id}")
    public void addNewChildByEmployeesID (@RequestBody ChildOfEmployee childOfEmployee,
                            @PathVariable ("id") Long id) {
        Employee employee = new Employee();
        employee = employeeService.fetchEmployeeByID(id);
        childOfEmployee.setChildName(childOfEmployee.getChildName());
        childOfEmployee.setChildSurname(childOfEmployee.getChildSurname());
        childOfEmployee.setChildPersonalCode(childOfEmployee.getChildPersonalCode());
        childOfEmployee.setChildDateOfBirth(childOfEmployee.getChildDateOfBirth());
     childOfEmployee.setEmployee(employee);
        childService.addNewChild(childOfEmployee);}
    @PutMapping("/children/{id}")
    public ChildOfEmployee updateChild(@PathVariable("id") Long id, @RequestBody ChildOfEmployee childOfEmployee) {
        return childService.updateChild(id, childOfEmployee);
    }

    @DeleteMapping("/children/{id}")
    public void deleteChild(@PathVariable("id") Long id) {
        childService.deleteChildByID(id);
    }

    @PostMapping("/employees/children/")
    public void saveEmployeeChild(@RequestBody ChildOfEmployee childOfEmployee) {

        childOfEmployee.setChildName(childOfEmployee.getChildName());
        childOfEmployee.setChildSurname(childOfEmployee.getChildSurname());
        childOfEmployee.setChildPersonalCode(childOfEmployee.getChildPersonalCode());
        childOfEmployee.setChildDateOfBirth(childOfEmployee.getChildDateOfBirth());
        childOfEmployee.setEmployee(childOfEmployee.getEmployee());
        childService.addNewChild(childOfEmployee);}

//
//    @GetMapping("/children")
//    public ResponseEntity<Iterable<ChildOfEmployee>> getAllChildOfEmployees(@RequestParam(required = false) String surname) {
//        try {
//            List<ChildOfEmployee> childOfEmployees = new ArrayList<ChildOfEmployee>();
//
//            if (surname == null) {
//                childRepository.findAll().forEach(childOfEmployees::add);
//            } else {
//                childRepository.findByChildSurname(surname).forEach(childOfEmployees::add);
//            }
//
//            if (childOfEmployees.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(childOfEmployees, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PostMapping("/children")
//    public ResponseEntity<ChildOfEmployee> addNewChildOfEmployee(@RequestBody ChildOfEmployee childOfEmployee) {
//        try {
//            ChildOfEmployee _childOfEmployee = childRepository
//                    .save(new ChildOfEmployee(childOfEmployee.getChildName(), childOfEmployee.getChildName(),
//                            childOfEmployee.getChildDateOfBirth(), childOfEmployee.getChildPersonalCode());
//            return new ResponseEntity<>(_childOfEmployee, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PutMapping("/children/{id}")
//    public ResponseEntity<ChildOfEmployee> updateChildOfEmployee(@PathVariable("id") Long id, @RequestBody ChildOfEmployee childOfEmployee) {
//        Optional<ChildOfEmployee> childOfEmployeeData = childRepository.findById(id);
//
//        if (childOfEmployeeData.isPresent()) {
//            ChildOfEmployee _childOfEmployee = childOfEmployeeData.get();
//            _childOfEmployee.setChildName(childOfEmployee.getChildName());
//            _childOfEmployee.setChildSurname(childOfEmployee.getChildSurname());
//            _childOfEmployee.setChildDateOfBirth(childOfEmployee.getChildDateOfBirth());
//            return new ResponseEntity<>(childRepository.save(_childOfEmployee), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}






















