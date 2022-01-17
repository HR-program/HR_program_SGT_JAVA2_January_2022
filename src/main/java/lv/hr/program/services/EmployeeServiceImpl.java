package lv.hr.program.services;

import lv.hr.program.model.Employee;
import lv.hr.program.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    public Employee update(Long Id, Employee employee) {
        employeeRepository.save(employee);
        return employee;
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



//package lv.hr.program.services;
//
//import lv.hr.program.model.Employee;
//import lv.hr.program.repositories.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.Locale;
//import java.util.Optional;
//
//@Service
////@RequiredArgsConstructor
////@Transactional
////@Slf4j
//public class EmployeeServiceImpl implements EmployeeService {
//
//    private final EmployeeRepository employeeRepository;
//public class EmployeeServiceImpl implements EmployeeService{
//@Autowired
//    private EmployeeRepository employeeRepository;

//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public Iterable<Employee> getAllEmployees() {
////        log.info("Full list of employees is:");
//
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee create(Employee employee) {
////        log.info("Adding new employee {} to the database:", employee.getName());
//    public void create(Employee employee) {
//         employeeRepository.save(employee);
//    }
//
//    @Override
//    public Employee update(Long id, Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    @Override
//    public void update(Long Id, Employee employee) {
//        log.info("Information of employee {} {} was changed:", employee.getName(), employee.getSurname());
//        employeeRepository.save(employee);
//    }
//
//    @Override
//    public void deleteEmployeeByID(Long Id) {
//        log.info("The employee will be deleted by ID in database:");
//        employeeRepository.deleteById(Id);
//    }
//
//
//
//
//    @Override
//    public Iterable<Employee> fetchEmployeeByPersonalCodeLike(String personalCode) {
//        return employeeRepository.findByPersonalCodeLike("%"+personalCode+"%");
//    }
//    @Override
//    public Employee fetchEmployeeByID(Long Id) {
//        return employeeRepository.findById(Id).get();
//    }
//
//    @Override
//    public Iterable<Employee> sortAllEmployeesByName() {
//        log.info("The employees are sorted by name in ascending order:");
//        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
//    }
//
//    @Override
//    public Iterable<Employee> sortAllEmployeesBySurname() {
//        log.info("The employees are sorted by surname in ascending order:");
//        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
//    }
//
//    @Override
//    public Iterable<Employee> findByNameLike(String name) {
//        log.info("The employee will be found by name:");
//        return employeeRepository.findByName("%" + name + "%");
//    }
//
//    @Override
//    public Iterable<Employee> findBySurnameLike(String surname) {
//        log.info("The employee will be found by surname:");
//        return employeeRepository.findBySurname("%" + surname + "%");
//    public Iterable<Employee> fetchEmployeeBySurnameLikeIgnoreCase(String surname) {
//        return employeeRepository.findBySurnameLikeIgnoreCase("%"+surname+"%");
//    }
//
//    @Override
//    public Iterable<Employee> getAllActiveEmployees() {
//        return employeeRepository.findAllActiveEmployees();
//    }
//
//    @Override
//    public Iterable<Employee> getEmployeesByDepartmentId(Long id) {
//        return employeeRepository.findByDepartmentId(id);
//    }
//
//    @Override
//    public Iterable<Employee> fetchEmployeeByNameLikeIgnoreCase(String name) {
//        return employeeRepository.findByNameLikeIgnoreCase("%"+name+"%");



//        @Override
//        public Iterable<Employee> getAllEmployees() {
//            log.info("Full list of employees is:");
//            return employeeRepository.findAll();
//        }
//
//        @Override
//        public Employee create(Employee employee) {
//            log.info("Adding new employee {} to the database:", employee.getName());
//            return employeeRepository.save(employee);
//        }
//
//        @Override
//        public void update(Long Id, Employee employee) {
//            log.info("Information of employee {} {} was changed:", employee.getName(), employee.getSurname());
//            employeeRepository.save(employee);
//        }
//
//        @Override
//        public void deleteEmployeeByID(Long Id) {
//            log.info("The employee will be deleted by ID in database:");
//            employeeRepository.deleteById(Id);
//        }
//
//        @Override
//        public Iterable<Employee> sortAllEmployeesByName() {
//            log.info("The employees are sorted by name in ascending order:");
//            return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
//        }
//
//        @Override
//        public Iterable<Employee> sortAllEmployeesBySurname() {
//            log.info("The employees are sorted by surname in ascending order:");
//            return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
//        }
//
//        @Override
//        public Iterable<Employee> findByNameLike(String name) {
//            log.info("The employee will be found by name:");
//            return employeeRepository.findByName("%" + name + "%");
//        }
//
//        @Override
//        public Iterable<Employee> findBySurnameLike(String surname) {
//            log.info("The employee will be found by surname:");
//            return employeeRepository.findBySurname("%" + surname + "%");
//        }


