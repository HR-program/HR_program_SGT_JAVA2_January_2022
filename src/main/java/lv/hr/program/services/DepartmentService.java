package lv.hr.program.services;

import lv.hr.program.model.Department;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface DepartmentService {

    @NotNull
    List<Department> getAllDepartments();

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
