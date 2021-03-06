package lv.hr.program.repositories;

import lv.hr.program.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Iterable<Department> findByName(String name);

    Iterable<Department> findByAddress(String address);
}
