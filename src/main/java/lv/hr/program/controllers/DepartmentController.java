package lv.hr.program.controllers;


import lv.hr.program.model.Department;
import lv.hr.program.repositories.DepartmentRepository;
import lv.hr.program.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    @GetMapping("/departments")
//    public Iterable<Department> getAllDepartments() {
//        return departmentService.getAllDepartments();
//    }

    @GetMapping("/departments")
    public ResponseEntity<Iterable<Department>> getAllDepartments() {
        try {
            if (departmentService.getAllDepartments().isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//        @PostMapping("/departments/add")
//        public Department addNewDepartment (@RequestBody Department department){
//            return departmentService.addNewDepartment(department);
//        }

    @PostMapping("/departments/add")
    public ResponseEntity<Department> addNewDepartment(@RequestBody Department department) {
        try {
            Department departmentSaved = departmentService.addNewDepartment(department);
            return new ResponseEntity<>(departmentSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/departments/{id}")
//    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
//        return departmentService.updateDepartment(id, department);
//    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        Optional<Department> departmentData = departmentRepository.findById(id);

        if (departmentData.isPresent()) {
            Department departmentToBeUpdated = departmentData.get();
            departmentToBeUpdated.setName(department.getName());
            departmentToBeUpdated.setAddress(department.getAddress());
            return new ResponseEntity<>(departmentService.updateDepartment(id, department), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping("/departments/{id}")
//    public void deleteDepartment(@PathVariable("id") Long id) {
//        departmentService.deleteDepartmentById(id);
//    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id) {
        try {
            departmentService.deleteDepartmentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) {
        return departmentService.fetchDepartmentById(id);
    }

    @GetMapping("/departments/sort-by-name")
    public Iterable<Department> sortAllDepartmentsByName() {
        return departmentService.sortAllDepartmentsByName();
    }

    @GetMapping("/departments/sort-by-address")
    public Iterable<Department> sortAllDepartmentsByAddress() {
        return departmentService.sortAllDepartmentsByAddress();
    }
}
