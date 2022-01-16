package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface ChildService {
    List<ChildOfEmployee> getAllChildren();

    ChildOfEmployee addNewChild(ChildOfEmployee childOfEmployee);

    ChildOfEmployee updateChild(Long id, ChildOfEmployee childOfEmployee);

    void deleteChildByID(Long id);

    Iterable<ChildOfEmployee> findByEmployeeId(Long id);
    @NotNull
    void deleteChildOfEmployeeByID(Long Id);

    @NotNull
    Iterable<ChildOfEmployee> sortAllChildOfEmployeeByName();

    @NotNull
    Iterable<ChildOfEmployee> sortAllChildOfEmployeeBySurname();


}
