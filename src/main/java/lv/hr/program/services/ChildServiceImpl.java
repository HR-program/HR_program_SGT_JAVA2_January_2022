package lv.hr.program.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.repositories.ChildRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ChildServiceImpl implements ChildService {

    private ChildRepository childRepository;

    @Override
    public List<ChildOfEmployee> getAllChildren() {
        log.info("Full list of children of employees is:");
        return childRepository.findAll();
    }

    @Override
    public ChildOfEmployee addNewChild(ChildOfEmployee childOfEmployee) {
        log.info("Adding new child of employee {} to the database:", childOfEmployee.getChildName());
        childRepository.save(childOfEmployee);
        return childOfEmployee;
    }

    @Override
    public ChildOfEmployee updateChild(Long id, ChildOfEmployee childOfEmployee) {
        log.info("Information of child of employee {} {} was changed:", childOfEmployee.getChildName(), childOfEmployee.getChildSurname());
        return childRepository.save(childOfEmployee);
    }

    @Override
    public void deleteChildByID(Long id) {
        log.info("The child of employee will be deleted by ID in database:");
        childRepository.deleteById(id);
    }

    @Override
    public Iterable<ChildOfEmployee> findByEmployeeId(Long id) {
        log.info("The child of employee will be found by ID in database:");
        return childRepository.findByEmployeeId(id);
    }

    @Override
    public Iterable<ChildOfEmployee> sortAllChildrenByName() {
        log.info("The children of employees are sorted by name in ascending order:");
        return childRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Iterable<ChildOfEmployee> sortAllChildrenBySurname() {
        log.info("The children of employees are sorted by surname in ascending order:");
        return childRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }
}
