package lv.hr.program.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.repositories.ChildOfEmployeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ChildOfEmployeeServiceImpl implements ChildOfEmployeeService{

    private final ChildOfEmployeeRepository childOfEmployeeRepository;

    @Override
    public Iterable<ChildOfEmployee> getAllChildOfEmployee() {
        log.info("Full list of children of employees is:");
        return childOfEmployeeRepository.findAll();
    }

    @Override
    public ChildOfEmployee create(ChildOfEmployee childOfEmployee) {
        log.info("Adding new child of employee {} to the database:", childOfEmployee.getName());
        return childOfEmployeeRepository.save(childOfEmployee);
    }

    @Override
    public void update(Long Id, ChildOfEmployee childOfEmployee) {
        log.info("Information of child of employee {} {} was changed:", childOfEmployee.getName(), childOfEmployee.getSurname());
        childOfEmployeeRepository.save(childOfEmployee);
    }

    @Override
    public void deleteChildOfEmployeeByID(Long Id) {
        log.info("The child of employee will be deleted by ID in database:");
        childOfEmployeeRepository.deleteById(Id);
    }

    @Override
    public Iterable<ChildOfEmployee> sortAllChildOfEmployeeByName() {
        log.info("The children of employees are sorted by name in ascending order:");
        return childOfEmployeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }


    @Override
    public Iterable<ChildOfEmployee> sortAllChildOfEmployeeBySurname() {
        log.info("The children of employees are sorted by surname in ascending order:");
        return childOfEmployeeRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }
}
