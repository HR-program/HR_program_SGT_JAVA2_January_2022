package lv.hr.program.repositories;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Iterable<Employee> findByPersonalCodeLike(String personalCode);

//    Iterable<Employee> findBySurname(String surname);
    Iterable<Employee> findBySurnameLike(String surname);

    Iterable<Employee>findByNameLike(String name);

    List<Employee> findByDepartmentId(long departmentId);
}
