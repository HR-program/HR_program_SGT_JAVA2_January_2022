package lv.hr.program.services;

import lv.hr.program.model.Employee;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface EmployeeService {

    @NotNull
    List<Employee> getAllEmployees();

    Employee create(Employee employee);

    Employee update(Long id, Employee employee);

    void deleteEmployeeByID(Long Id);

    Iterable<Employee> fetchEmployeeByPersonalCodeLike(String personalCode);

    Employee fetchEmployeeByID(Long Id);

    @NotNull
    Iterable<Employee> sortAllEmployeesByName();

    @NotNull
    Iterable<Employee> sortAllEmployeesBySurname();

    Iterable<Employee> fetchEmployeeByNameLikeIgnoreCase(String name);

    Iterable<Employee> fetchEmployeeBySurnameLikeIgnoreCase(String surname);

    List<Employee> getAllActiveEmployees();

    Iterable<Employee> getEmployeesByDepartmentId(Long id);

    Iterable<Employee> getAllActiveEmployeesAndSortByName();

    Iterable<Employee> getAllActiveEmployeesAndSortBySurname();
}
