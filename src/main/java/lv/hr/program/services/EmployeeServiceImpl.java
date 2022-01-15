package lv.hr.program.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getAllEmployees() {
        log.info("Full list of employees is:");
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        log.info("Adding new employee {} to the database:", employee.getName());
        employeeRepository.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        log.info("Information of employee {} {} was changed:", employee.getName(), employee.getSurname());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeByID(Long Id) {
        log.info("The employee will be deleted by ID in database:");
        employeeRepository.deleteById(Id);
    }

    @Override
    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(String personalCode) {
        log.info("The employee will be found by the part of personal code:");
        return employeeRepository.findByPersonalCodeLike("%" + personalCode + "%");
    }

    @Override
    public Employee fetchEmployeeByID(Long Id) {
        log.info("The employee will be found by ID in database:");
        return employeeRepository.findById(Id).get();
    }

    @Override
    public Iterable<Employee> sortAllEmployeesByName() {
        log.info("The employees are sorted by name in ascending order:");
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Iterable<Employee> sortAllEmployeesBySurname() {
        log.info("The employees are sorted by surname in ascending order:");        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }

    @Override
    public Iterable<Employee> fetchEmployeeBySurnameLikeIgnoreCase(String surname) {
        log.info("The employee will be found by the part of surname:");
        return employeeRepository.findBySurnameLikeIgnoreCase("%" + surname + "%");
    }

    @Override
    public Iterable<Employee> getAllActiveEmployees() {
        log.info("Full list of active employees is:");
        return employeeRepository.findAllActiveEmployees();
    }

    @Override
    public Iterable<Employee> getEmployeesByDepartmentId(Long id) {
        log.info("Full list of employees of department:");
        return employeeRepository.findByDepartmentId(id);
    }

    @Override
    public Iterable<Employee> fetchEmployeeByNameLikeIgnoreCase(String name) {
        log.info("The employee will be found by the part of name:");
        return employeeRepository.findByNameLikeIgnoreCase("%" + name + "%");
    }
}
