package lv.hr.program.controllers;

import lombok.RequiredArgsConstructor;
import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.repositories.ChildOfEmployeeRepository;
import lv.hr.program.services.ChildOfEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class ChildController {

    private final ChildOfEmployeeService childOfEmployeeService;

    private final ChildOfEmployeeRepository childOfEmployeeRepository;

    @GetMapping("/children")
    public ResponseEntity<Iterable<ChildOfEmployee>> getAllChildOfEmployees(@RequestParam(required = false) String surname) {
        try {
            List<ChildOfEmployee> childOfEmployees = new ArrayList<ChildOfEmployee>();

            if (surname == null) {
                childOfEmployeeRepository.findAll().forEach(childOfEmployees::add);
            } else {
                childOfEmployeeRepository.findBySurname(surname).forEach(childOfEmployees::add);
            }

            if (childOfEmployees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(childOfEmployees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/children")
    public ResponseEntity<ChildOfEmployee> addNewChildOfEmployee(@RequestBody ChildOfEmployee childOfEmployee) {
        try {
            ChildOfEmployee _childOfEmployee = childOfEmployeeRepository
                    .save(new ChildOfEmployee(childOfEmployee.getName(), childOfEmployee.getSurname(),
                            childOfEmployee.getDateOfBirth(), childOfEmployee.getPersonalCode()));
            return new ResponseEntity<>(_childOfEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/children/{id}")
    public ResponseEntity<ChildOfEmployee> updateChildOfEmployee(@PathVariable("id") Long id, @RequestBody ChildOfEmployee childOfEmployee) {
        Optional<ChildOfEmployee> childOfEmployeeData = childOfEmployeeRepository.findById(id);

        if (childOfEmployeeData.isPresent()) {
            ChildOfEmployee _childOfEmployee = childOfEmployeeData.get();
            _childOfEmployee.setName(childOfEmployee.getName());
            _childOfEmployee.setSurname(childOfEmployee.getSurname());
            _childOfEmployee.setDateOfBirth(childOfEmployee.getDateOfBirth());
            return new ResponseEntity<>(childOfEmployeeRepository.save(_childOfEmployee), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
