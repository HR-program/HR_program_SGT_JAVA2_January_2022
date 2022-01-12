package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Department;
import lv.hr.program.model.Employee;

public interface DepartmentService {


    Iterable<Department> getAllDepartments();

    Department addNewDepartment(Department department);

    Department updateDepartment(Long id, Department department);

    void deleteDepartmentById(Long id);

    Department fetchDepartmentByID(Long id);


}
