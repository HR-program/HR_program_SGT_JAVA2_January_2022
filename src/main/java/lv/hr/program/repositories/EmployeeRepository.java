package lv.hr.program.repositories;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Iterable<Employee> findByPersonalCodeLike(String personalCode);

//    Iterable<Employee> findBySurname(String surname);
    Iterable<Employee> findBySurnameLikeIgnoreCase(String surname);

//    Iterable<Employee>findByNameLike(String name);
    Iterable<Employee>findByNameLikeIgnoreCase(String name);


    Iterable<Employee>findByDepartmentId(Long id);

    @Query(value ="SELECT * FROM employee WHERE employee_is_active_worker = 1",  nativeQuery = true)
    Iterable<Employee> findAllActiveEmployees();


}
