package lv.hr.program.services;

import lv.hr.program.model.Department;

import javax.validation.constraints.NotNull;

public interface DepartmentService {

    Iterable<Department> getAllDepartments();

    Department addNewDepartment(Department department);

    Department updateDepartment(Long id, Department department);

    void deleteDepartmentById(Long id);

    Department fetchDepartmentByID(Long id);

    @NotNull
    Iterable<Department> findByName(String name);

    @NotNull
    Iterable<Department> sortAllDepartmentsByName();

    @NotNull
    Iterable<Department> sortAllDepartmentsByAddress();


}
