package lv.hr.program.repositories;

import lv.hr.program.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

//    Employee findByIdNumber(String idNumber);
//
//    Iterable<Employee> findBySurname(String surname);

    Iterable<Employee> findBySurnameLike(String surname);
}
