package lv.hr.program.repositories;

import lv.hr.program.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findById(Long id);

    Iterable<Department> findByName(String name);

    Iterable<Department> findByAddress(String address);
}
