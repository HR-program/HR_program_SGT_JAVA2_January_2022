package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;

import java.util.List;
import java.util.Optional;

public interface ChildService {
    List<ChildOfEmployee> getAllChildren();

    ChildOfEmployee addNewChild(ChildOfEmployee childOfEmployee);

    ChildOfEmployee updateChild(Long id, ChildOfEmployee childOfEmployee);

    void deleteChildByID(Long id);

    Iterable<ChildOfEmployee> findByEmployeeId(Long id);


}
