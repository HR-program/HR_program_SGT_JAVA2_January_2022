package lv.hr.program.services;

import lv.hr.program.model.Employee;

import javax.validation.constraints.NotNull;

public interface EmployeeService {
    @NotNull Iterable<Employee> getAllEmployees();
    public void create(Employee employee);
    public  void update(Long Id ,Employee employee);
    public  void deleteEmployeeByID(Long Id);

   Iterable <Employee> fetchEmployeeByPersonalCodeLike(String personalCode);

//    Iterable<Employee> fetchEmployeeBySurname(String surname);

    Employee fetchEmployeeByID(Long Id);
    @NotNull Iterable<Employee> sortAllEmployeesByName();
    @NotNull Iterable<Employee> sortAllEmployeesBySurname();

    Iterable<Employee> fetchEmployeeBySurnameLike(String surname);

    Iterable<Employee> fetchEmployeeByNameLike(String name);
}
