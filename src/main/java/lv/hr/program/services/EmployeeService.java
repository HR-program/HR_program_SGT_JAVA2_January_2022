package lv.hr.program.services;

import lv.hr.program.model.Employee;

import javax.validation.constraints.NotNull;

public interface EmployeeService {

    @NotNull
    Iterable<Employee> getAllEmployees();

    Employee create(Employee employee);

    @NotNull
    void update(Long Id, Employee employee);

    @NotNull
    void deleteEmployeeByID(Long Id);

    @NotNull
    Iterable<Employee> sortAllEmployeesByName();

    @NotNull
    Iterable<Employee> sortAllEmployeesBySurname();

    Iterable<Employee> findByNameLike(String name);

    Iterable<Employee> findBySurnameLike(String surname);
}
