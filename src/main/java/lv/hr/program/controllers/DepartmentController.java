package lv.hr.program.controllers;

import lombok.RequiredArgsConstructor;
import lv.hr.program.model.Department;
import lv.hr.program.repositories.DepartmentRepository;
import lv.hr.program.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/v1/")
public class DepartmentController {

    private DepartmentService departmentService;

    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public Iterable<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

//    @GetMapping("/departments")
//    public ResponseEntity<Iterable<Department>> getAllDepartments(@RequestParam(required = false) String name) {
//        try {
//            List<Department> departments = new ArrayList<Department>();
//
//            if (name == null) {
//                departmentRepository.findAll().forEach(departments::add);
//            } else {
//                departmentService.findByName(name).forEach(departments::add);
//            }
//
//            if (departments.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(departments, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id){
        return departmentService.fetchDepartmentByID(id);
    }

    @PostMapping("/departments/add")
    public Department addNewDepartment(@RequestBody Department department) {
        return departmentService.addNewDepartment(department);
    }

//    @PostMapping("/departments/add")
//    public ResponseEntity<Department> addNewDepartment(@RequestBody Department department) {
//        try {
//            Department _department = departmentRepository
//                    .save(new Department(department.getName(), department.getAddress()));
//            return new ResponseEntity<>(_department, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

//    @PutMapping("/departments/{id}")
//    public ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
//        Optional<Department> departmentData = departmentRepository.findById(id);
//
//        if (departmentData.isPresent()) {
//            Department _department = departmentData.get();
//            _department.setName(department.getName());
//            _department.setAddress(department.getAddress());
//
//            return new ResponseEntity<>(departmentRepository.save(_department), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentById(id);
    }

//    @DeleteMapping("/departments/{id}")
//    public ResponseEntity<HttpStatus> deleteDepartment(@PathVariable("id") Long id) {
//        try {
//            departmentService.deleteDepartmentById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @GetMapping("/departments/sort-by-name")
    public Iterable<Department> sortAllDepartmentsByName() {
        return departmentService.sortAllDepartmentsByName();
    }

    @GetMapping("/departments/sort-by-address")
    public Iterable<Department> sortAllEmployeesBySurname() {
        return departmentService.sortAllDepartmentsByAddress();
    }
}
