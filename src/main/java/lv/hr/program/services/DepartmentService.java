package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Department;
import lv.hr.program.model.Employee;

import javax.validation.constraints.NotNull;

public interface DepartmentService {

    @NotNull
    Iterable<Department> getAllDepartments();

    Department addNewDepartment(Department department);

    Department updateDepartment(Long id, Department department);
    @NotNull
    void deleteDepartmentById(Long id);

    Department fetchDepartmentById(Long id);



    @NotNull
    Iterable<Department> sortAllDepartmentsByName();

    @NotNull
    Iterable<Department> sortAllDepartmentsByAddress();

    @NotNull
    Iterable<Department> findByName(String name);


}



