package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ChildService {

    List<ChildOfEmployee> getAllChildren();

    ChildOfEmployee addNewChild(ChildOfEmployee childOfEmployee);

    ChildOfEmployee updateChild(Long id, ChildOfEmployee childOfEmployee);

    void deleteChildByID(Long id);

    Iterable<ChildOfEmployee> findByEmployeeId(Long id);

    @NotNull
    Iterable<ChildOfEmployee> sortAllChildrenByName();

    @NotNull
    Iterable<ChildOfEmployee> sortAllChildrenBySurname();

}
