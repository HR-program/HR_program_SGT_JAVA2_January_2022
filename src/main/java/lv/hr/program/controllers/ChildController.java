package lv.hr.program.controllers;


import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import lv.hr.program.services.ChildService;
import lv.hr.program.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1/")
public class ChildController {

    private ChildService childService;
    private EmployeeService employeeService;

    public ChildController(ChildService childService, EmployeeService employeeService) {
        this.childService = childService;
        this.employeeService = employeeService;
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
        childService.addNewChild(childOfEmployee);}}






















