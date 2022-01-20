package lv.hr.program.repositories;

import lv.hr.program.model.ChildOfEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<ChildOfEmployee, Long> {

    Iterable<ChildOfEmployee> findByEmployeeId(long employeeId);

    ChildOfEmployee findChildOfEmployeeByChildId(Long childId);

    Iterable<ChildOfEmployee> findByAgeOfChildLessThan(int ageOfChild);

    Iterable<ChildOfEmployee> findAllByOrderByEmployeeSurname();
}
