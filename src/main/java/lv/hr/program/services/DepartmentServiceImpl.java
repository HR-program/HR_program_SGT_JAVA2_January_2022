package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Department;
import lv.hr.program.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
@Autowired
    private DepartmentRepository departmentRepository;


    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Iterable<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addNewDepartment(Department department) {
         return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(Long id) {
     departmentRepository.deleteById(id);

    }


    @Override
    public Department fetchDepartmentById(Long id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Iterable<Department> sortAllDepartmentsByName() {
        return departmentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Iterable<Department> sortAllDepartmentsByAddress() {
        return departmentRepository.findAll(Sort.by(Sort.Direction.ASC, "address"));
    }

    @Override
    public Iterable<Department> findByName(String name) {
        return  departmentRepository.findByName(name);
    }

}

