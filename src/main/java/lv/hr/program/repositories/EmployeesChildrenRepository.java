package lv.hr.program.repositories;

import lv.hr.program.model.EmployeesChildren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesChildrenRepository extends JpaRepository < EmployeesChildren, Long> {

    @Query(value="SELECT employee_name, employee_surname, child_id, child_date_of_birth, child_name, child_personal_code, child_surname\n" +
            "From employee\n" +
            "INNER JOIN child\n" +
            "ON employee.employee_id =child.employee_employee_id; ", nativeQuery = true)
    List<Object[]> findChildren();
}
