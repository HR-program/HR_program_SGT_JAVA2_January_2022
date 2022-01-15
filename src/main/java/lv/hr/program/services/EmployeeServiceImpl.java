package lv.hr.program.services;

import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
         employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeByID(Long Id) {
        employeeRepository.deleteById(Id);
    }
    @Override
    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(String personalCode) {
        return employeeRepository.findByPersonalCodeLike("%"+personalCode+"%");
    }
    @Override
    public Employee fetchEmployeeByID(Long Id) {
        return employeeRepository.findById(Id).get();
    }
    @Override
    public Iterable<Employee> sortAllEmployeesByName() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
    @Override
    public Iterable<Employee> sortAllEmployeesBySurname() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }

    @Override
    public Iterable<Employee> fetchEmployeeBySurnameLikeIgnoreCase(String surname) {
        return employeeRepository.findBySurnameLikeIgnoreCase("%"+surname+"%");
    }

    @Override
    public Iterable<Employee> getAllActiveEmployees() {
        return employeeRepository.findAllActiveEmployees();
    }

    @Override
    public Iterable<Employee> getEmployeesByDepartmentId(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public Iterable<Employee> fetchEmployeeByNameLikeIgnoreCase(String name) {
        return employeeRepository.findByNameLikeIgnoreCase("%"+name+"%");
    }
}
