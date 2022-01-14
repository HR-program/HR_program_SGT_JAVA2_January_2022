package lv.hr.program.services;

import lv.hr.program.model.Department;

import javax.validation.constraints.NotNull;

public interface DepartmentService {

    @NotNull
    Iterable<Department> getAllDepartments();

    Department create(Department department);

    @NotNull
    void update(Long Id, Department department);

    @NotNull
    void deleteDepartmentByID(Long Id);

    @NotNull
    Iterable<Department> sortAllDepartmentsByName();

    @NotNull
    Iterable<Department> sortAllDepartmentsByAddress();

    @NotNull
    Iterable<Department> findByName(String name);
}
