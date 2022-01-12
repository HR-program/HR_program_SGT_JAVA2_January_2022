package lv.hr.program.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lv.hr.program.exception.ResourceNotFoundException;
import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import lv.hr.program.model.EmployeesChildren;
import lv.hr.program.repositories.ChildRepository;
import lv.hr.program.repositories.EmployeeRepository;
import lv.hr.program.repositories.EmployeesChildrenRepository;
import lv.hr.program.services.ChildService;
import lv.hr.program.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/v1/")
public class ChildController {
    @Autowired
    private ChildService childService;


    public ChildController(ChildService childrenService) {
        this.childService = childrenService;
    }
@Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeesChildrenRepository employeesChildrenRepository;

    @GetMapping("/children")
public List<ChildOfEmployee>getAllChildren(){return childService.getAllChildren();}

    @PostMapping("/children")
    public ResponseEntity<ChildOfEmployee>addNewChild(@RequestBody ChildOfEmployee childOfEmployee) {
        try {
            ChildOfEmployee childOfEmployeeSaved = childService.addNewChild(childOfEmployee);

            return new ResponseEntity<>(childOfEmployeeSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/children/{id}")
    public ChildOfEmployee updateChild(@PathVariable("id") Long id, @RequestBody ChildOfEmployee childOfEmployee) {
        return childService.updateChild(id, childOfEmployee);
    }

    @DeleteMapping("/children/{id}")
    public void deleteChild(@PathVariable("id") Long id) {
        childService.deleteChildByID(id);

    }

    @GetMapping("/employees/children")
    public List<EmployeesChildren> getEmployeesChildren(){
        List<EmployeesChildren>employeesChildren= new ArrayList<>();
        for (Object[] o : employeesChildrenRepository.findChildren()){
            EmployeesChildren employeesChild = new EmployeesChildren();
            employeesChild.setChildId(Long.parseLong(String.valueOf(o[0])));
            employeesChild.setChildName((String)o[1]);
            employeesChild.setChildSurname((String)o[2]);
            employeesChild.setChildPersonalCode((String)o[3]);
//            employeesChild.setChildDateOfBirth(Long.parseLong(String.valueOf(o[0])));
            employeesChild.setEmployeesId(Long.parseLong(String.valueOf(o[5])));
            employeesChild.setEmployeesName((String)o[6]);
            employeesChild.setEmployeesSurname((String)o[6]);
            employeesChildren.add(employeesChild);
        }
        return employeesChildren;
    }





//    @PostMapping("/employee/{employeeId}/child")
//    public void addChildByEmployee(@PathVariable(value = "employee") Long employeelId,
//                                                 @RequestBody ChildOfEmployee childOfEmployee) {
//
//        childService.addChildByParent(childOfEmployee,employeelId);


    //    @PostMapping("/employee/{employeeId}/child")
//    public ResponseEntity<ChildOfEmployee> addNewChildByParent (@PathVariable(value = "employeeId") Long id,
//                                                         @RequestBody ChildOfEmployee childOfEmployeeRequest) {
//  childService.addChildByParent(childOfEmployeeRequest,id);
//        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
//
//        return new ResponseEntity<>(chid, HttpStatus.CREATED);
//    }
//}
    @GetMapping("/children/{id}")
    public Iterable<ChildOfEmployee>getAllByEmployeeChildren(@PathVariable Long id){return childService.findByEmployeeId(id);}}









//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
//
//        if (tutorialData.isPresent()) {
//            Tutorial _tutorial = tutorialData.get();
//            _tutorial.setTitle(tutorial.getTitle());
//            _tutorial.setDescription(tutorial.getDescription());
//            _tutorial.setPublished(tutorial.isPublished());
//            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }






