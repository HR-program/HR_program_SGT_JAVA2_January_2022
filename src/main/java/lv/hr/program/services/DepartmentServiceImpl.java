package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Department;
import lv.hr.program.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Department fetchDepartmentByID(Long id) {
        return departmentRepository.findById(id).get();
    }
}

