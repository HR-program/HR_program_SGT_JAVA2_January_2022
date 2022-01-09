package lv.hr.program.services;

import lv.hr.program.model.Employee;

import javax.validation.constraints.NotNull;

public interface EmployeeService {
    @NotNull Iterable<Employee> getAllEmployees();
    Employee create(Employee employee);
    void update(Long Id ,Employee employee);
    void deleteEmployeeByID(Long Id);

//    Employee fetchEmployeeByIdNumber(String idNumber);

    Iterable<Employee> fetchEmployeeBySurname(String surname);

}
