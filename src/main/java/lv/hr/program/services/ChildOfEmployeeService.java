package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;

import javax.validation.constraints.NotNull;

public interface ChildOfEmployeeService {

    @NotNull
    Iterable<ChildOfEmployee> getAllChildOfEmployee();

    ChildOfEmployee create(ChildOfEmployee childOfEmployee);

    @NotNull
    void update(Long Id, ChildOfEmployee childOfEmployee);

    @NotNull
    void deleteChildOfEmployeeByID(Long Id);

    @NotNull
    Iterable<ChildOfEmployee> sortAllChildOfEmployeeByName();

    @NotNull
    Iterable<ChildOfEmployee> sortAllChildOfEmployeeBySurname();

}
