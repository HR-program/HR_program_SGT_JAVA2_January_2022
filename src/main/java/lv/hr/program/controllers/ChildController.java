package lv.hr.program.controllers;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.ChildRepository;
import lv.hr.program.services.ChildService;
import lv.hr.program.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class ChildController {

    private ChildService childService;
    private EmployeeService employeeService;
    private ChildRepository childRepository;

    public ChildController(ChildService childService, EmployeeService employeeService, ChildRepository childRepository) {
        this.childService = childService;
        this.employeeService = employeeService;
        this.childRepository = childRepository;
    }

//    @GetMapping("/children")
//    public List<ChildOfEmployee> getAllChildren() {
//        return childService.getAllChildren();
//    }

    @GetMapping("/children")
    public ResponseEntity<Iterable<ChildOfEmployee>> getAllChildren() {
        try {
            if (childService.getAllChildren().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(childService.getAllChildren(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/children/employee/{id}")
    public void addNewChildByEmployeesID(@RequestBody ChildOfEmployee childOfEmployee,
                                         @PathVariable("id") Long id) {
        Employee employee = new Employee();
        employee = employeeService.fetchEmployeeByID(id);
        childOfEmployee.setChildName(childOfEmployee.getChildName());
        childOfEmployee.setChildSurname(childOfEmployee.getChildSurname());
        childOfEmployee.setChildPersonalCode(childOfEmployee.getChildPersonalCode());
        childOfEmployee.setChildDateOfBirth(childOfEmployee.getChildDateOfBirth());
        childOfEmployee.setAgeOfChild(childOfEmployee.getAgeOfChild());
        childOfEmployee.setEmployee(employee);
        employee.setHavingChildrenToTrue();
        employeeService.update(id, employee);
        childService.addNewChild(childOfEmployee);
    }

//    @PostMapping("/employees/children/")
//    public void saveEmployeeChild(@RequestBody ChildOfEmployee childOfEmployee) {
//        childOfEmployee.setChildName(childOfEmployee.getChildName());
//        childOfEmployee.setChildSurname(childOfEmployee.getChildSurname());
//        childOfEmployee.setChildPersonalCode(childOfEmployee.getChildPersonalCode());
//        childOfEmployee.setChildDateOfBirth(childOfEmployee.getChildDateOfBirth());
//        childOfEmployee.setAgeOfChild(childOfEmployee.getAgeOfChild());
//        childOfEmployee.setEmployee(childOfEmployee.getEmployee());
//        childService.addNewChild(childOfEmployee);
//    }

//    @PostMapping("/children")
//    public ResponseEntity<ChildOfEmployee> addNewChild(@RequestBody ChildOfEmployee childOfEmployee) {
//        try {
//            ChildOfEmployee childOfEmployeeSaved = childService.addNewChild(childOfEmployee);
//            return new ResponseEntity<>(childOfEmployeeSaved, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    @PutMapping("/children/{id}")
//    public ChildOfEmployee updateChild(@PathVariable("id") Long id, @RequestBody ChildOfEmployee childOfEmployee) {
//        return childService.updateChild(id, childOfEmployee);
//    }

    @PutMapping("/children/{id}")
    public ResponseEntity<ChildOfEmployee> updateChild(@PathVariable("id") Long id, @RequestBody ChildOfEmployee childOfEmployee) {
        Optional<ChildOfEmployee> childOfEmployeeData = childRepository.findById(id);

        if (childOfEmployeeData.isPresent()) {
            ChildOfEmployee childOfEmployeeToBeUpdated = childOfEmployeeData.get();
            childOfEmployeeToBeUpdated.setChildPersonalCode(childOfEmployee.getChildPersonalCode());
            childOfEmployeeToBeUpdated.setChildDateOfBirth(childOfEmployee.getChildDateOfBirth());
            childOfEmployeeToBeUpdated.setChildName(childOfEmployee.getChildName());
            childOfEmployeeToBeUpdated.setChildSurname(childOfEmployee.getChildSurname());
            return new ResponseEntity<>(childService.updateChild(id, childOfEmployee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/children/{id}")
    public ChildOfEmployee findChildById(@PathVariable("id") Long childId) {
        return childRepository.findChildOfEmployeeByChildId(childId);
    }

    @DeleteMapping("/children/{id}")
    public void deleteChild(@PathVariable("id") Long id) {
        childService.deleteChildByID(id);
    }

    @GetMapping("/children/employee/{id}")
    public Iterable<ChildOfEmployee> findByEmployeesID(@PathVariable("id") Long id) {
        return childService.findByEmployeeId(id);
    }

    @GetMapping("children/age/{age}")
    public Iterable<ChildOfEmployee> findByAgeLessThan(@PathVariable("age") int ageOfChild) {
        return childService.findByAgeLessThan(ageOfChild);
    }

    @GetMapping("children/sort-by-age")
    public Iterable<ChildOfEmployee> sortByAgeOfChild() {
        return childService.sortByAgeOfChild();
    }

    @GetMapping("children/sort-by-age-desc")
    public Iterable<ChildOfEmployee> sortByAgeOfChildDesc() {
        return childService.sortByAgeOfChildDesc();
    }

    @GetMapping("children/group-by-parent")
    public Iterable<ChildOfEmployee> findAllByOrderByEmployeeSurname() {
        return childService.findAllByOrderByEmployeeSurname();
    }
}
