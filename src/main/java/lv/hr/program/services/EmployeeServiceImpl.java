package lv.hr.program.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getAllEmployees() {
        log.info("Full list of employees is:");
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        log.info("Adding new employee {} to the database:", employee.getName());
        return employeeRepository.save(employee);
    }

    @Override
    public void update(Long Id, Employee employee) {
        log.info("Information of employee {} {} was changed:", employee.getName(), employee.getSurname());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeByID(Long Id) {
        log.info("The employee will be deleted by ID in database:");
        employeeRepository.deleteById(Id);
    }

    @Override
    public Iterable<Employee> sortAllEmployeesByName() {
        log.info("The employees are sorted by name in ascending order:");
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Iterable<Employee> sortAllEmployeesBySurname() {
        log.info("The employees are sorted by surname in ascending order:");
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }

    @Override
    public Iterable<Employee> findByNameLike(String name) {
        log.info("The employee will be found by name:");
        return employeeRepository.findByName("%" + name + "%");
    }

    @Override
    public Iterable<Employee> findBySurnameLike(String surname) {
        log.info("The employee will be found by surname:");
        return employeeRepository.findBySurname("%" + surname + "%");
    }
}
