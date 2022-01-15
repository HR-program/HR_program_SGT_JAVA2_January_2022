package lv.hr.program.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.hr.program.model.Department;
import lv.hr.program.repositories.DepartmentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> getAllDepartments() {
        log.info("Full list of departments is:");
        return departmentRepository.findAll();
    }

    @Override
    public Department addNewDepartment(Department department) {
        log.info("Adding new department {} to the database:", department.getName());
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        log.info("Information of Department {} was changed:", department.getName());
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        log.info("The department will be deleted by ID from database:");
        departmentRepository.deleteById(id);
    }

    @Override
    public Department fetchDepartmentByID(Long id) {
        log.info("The department will be found by ID from database:");
        return departmentRepository.findById(id).get();
    }

    @Override
    public Iterable<Department> sortAllDepartmentsByName() {
        log.info("The departments are sorted by name in ascending order:");
        return departmentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Iterable<Department> sortAllDepartmentsByAddress() {
        log.info("The departments are sorted by address in ascending order:");
        return departmentRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }

    @Override
    public Iterable<Department> findByName(String name) {
        log.info("The department will be found by name:");
        return departmentRepository.findByName(name);
    }
}

