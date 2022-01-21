package lv.hr.program.services;

import lombok.extern.slf4j.Slf4j;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
//        log.info("Full list of employees is:");
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
//        log.info("Adding new employee {} to the database:", employee.getName());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee update(Long Id, Employee employee) {
//        log.info("Information of employee {} {} was changed:", employee.getName(), employee.getSurname());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployeeByID(Long Id) {
//        log.info("The employee will be deleted by ID in database:");
        employeeRepository.deleteById(Id);
    }

    @Override
    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(String personalCode) {
        return employeeRepository.findByPersonalCodeLike("%" + personalCode + "%");
    }

    @Override
    public Employee fetchEmployeeByID(Long Id) {
        return employeeRepository.findById(Id).get();
    }

    @Override
    public Iterable<Employee> sortAllEmployeesByName() {
//        log.info("The employees are sorted by name in ascending order:");
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Iterable<Employee> sortAllEmployeesBySurname() {
//        log.info("The employees are sorted by surname in ascending order:");
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }

    @Override
    public Iterable<Employee> fetchEmployeeByNameLikeIgnoreCase(String name) {
//        log.info("The employee will be found by name:");
        return employeeRepository.findByNameLikeIgnoreCase("%" + name + "%");
    }

    @Override
    public Iterable<Employee> fetchEmployeeBySurnameLikeIgnoreCase(String surname) {
//        log.info("The employee will be found by surname:");
        return employeeRepository.findBySurnameLikeIgnoreCase("%" + surname + "%");
    }

    @Override
    public List<Employee> getAllActiveEmployees() {
        return employeeRepository.findAllActiveEmployees();
    }

    @Override
    public Iterable<Employee> getEmployeesByDepartmentId(Long id) {
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public Iterable<Employee> getAllActiveEmployeesAndSortByName() {
        return employeeRepository.findAllActiveEmployeesAndSortByName();
    }

    @Override
    public Iterable<Employee> getAllActiveEmployeesAndSortBySurname() {
        return employeeRepository.findAllActiveEmployeesAndSortBySurname();
    }
}
