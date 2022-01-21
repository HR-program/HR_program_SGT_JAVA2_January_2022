package lv.hr.program.controllers;

import lv.hr.program.model.Department;
import lv.hr.program.repositories.DepartmentRepository;
import lv.hr.program.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {

    private DepartmentService departmentService;
    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentService departmentService, DepartmentRepository departmentRepository) {
        this.departmentService = departmentService;
        this.departmentRepository = departmentRepository;
    }

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

    @PostMapping("/departments/add")
    public ResponseEntity<Department> addNewDepartment(@RequestBody Department department) {
        try {
            Department departmentSaved = departmentService.addNewDepartment(department);
            return new ResponseEntity<>(departmentSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

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
