package lv.hr.program.services;

import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void update(Long Id, Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeByID(Long Id) {
        employeeRepository.deleteById(Id);

    }

    @Override
    public Employee fetchEmployeeByIdNumber(String idNumber) {
        return employeeRepository.findByIdNumber(idNumber);
    }

    @Override
    public Iterable<Employee> fetchEmployeeBySurname(String surname) {
        return employeeRepository.findBySurname(surname);
    }
}
