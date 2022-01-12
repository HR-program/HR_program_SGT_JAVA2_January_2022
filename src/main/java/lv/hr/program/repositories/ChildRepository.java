package lv.hr.program.repositories;

import lv.hr.program.model.ChildOfEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<ChildOfEmployee,Long> {

//    Iterable<ChildOfEmployee> findByEmployeeId(long employeeId);
//
//    @Transactional
//    void deleteByEmployeeId(long employeeId);


}

