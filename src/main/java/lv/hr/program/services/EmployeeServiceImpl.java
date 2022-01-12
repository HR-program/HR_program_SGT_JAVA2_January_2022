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
    public void update(Long Id, Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeByID(Long Id) {
        employeeRepository.deleteById(Id);

    }

    @Override
    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(String personalCode) {
        return employeeRepository.findByPersonalCodeLike("%"+personalCode+"%");
    }

//    @Override
//    public Iterable<Employee> fetchEmployeeBySurname(String surname) {
//        return employeeRepository.findBySurname(surname);
//    }



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
    public Iterable<Employee> fetchEmployeeBySurnameLike(String surname) {
        return employeeRepository.findBySurnameLike("%"+surname+"%");
    }

    @Override
    public Iterable<Employee> fetchEmployeeByNameLike(String name) {
        return employeeRepository.findByNameLike("%"+name+"%");
    }
}
