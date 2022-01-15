package lv.hr.program.repositories;

import lv.hr.program.model.ChildOfEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ChildOfEmployeeRepository extends JpaRepository<ChildOfEmployee, Long> {

    Optional<ChildOfEmployee> findById(Long id);

    Optional<ChildOfEmployee> findByDateOfBirth(LocalDate dateOfBirth);

    Optional<ChildOfEmployee> findByPersonalCode(String personalCode);

    Iterable<ChildOfEmployee> findBySurname(String surname);

}
