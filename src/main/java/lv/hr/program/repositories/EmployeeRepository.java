package lv.hr.program.repositories;

import lv.hr.program.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findById(Long id);

    Optional<Employee> findByPersonalCode(String personalCode);

    Iterable<Employee> findByName(String name);

    Iterable<Employee> findBySurname(String surname);

}
