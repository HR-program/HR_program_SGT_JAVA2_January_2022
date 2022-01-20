package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildRepository childRepository;

    Employee employee = new Employee();

    public ChildServiceImpl(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public List<ChildOfEmployee> getAllChildren() {
        return childRepository.findAll();
    }

    @Override
    public ChildOfEmployee addNewChild(ChildOfEmployee childOfEmployee) {
        childRepository.save(childOfEmployee);
        return childOfEmployee;
    }

    @Override
    public ChildOfEmployee fetchChildByID(Long Id) {
        return childRepository.findById(Id).get();
    }

    @Override
    public ChildOfEmployee updateChild(Long id, ChildOfEmployee childOfEmployee) {
        return childRepository.save(childOfEmployee);
    }

    @Override
    public void deleteChildByID(Long id) {
        childRepository.deleteById(id);
    }

    @Override
    public Iterable<ChildOfEmployee> findByEmployeeId(Long id) {

        return childRepository.findByEmployeeId(id);
    }

    @Override
    public void deleteChildOfEmployeeByID(Long Id) {
//        log.info("The child of employee will be deleted by ID in database:");
        childRepository.deleteById(Id);
    }

    @Override
    public Iterable<ChildOfEmployee> sortAllChildOfEmployeeByName() {
//        log.info("The children of employees are sorted by name in ascending order:");
        return childRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }


    @Override
    public Iterable<ChildOfEmployee> sortAllChildOfEmployeeBySurname() {
//        log.info("The children of employees are sorted by surname in ascending order:");
        return childRepository.findAll(Sort.by(Sort.Direction.ASC, "surname"));
    }

    @Override
    public ChildOfEmployee findChildOfEmployeeByChildId(Long childId) {
        return childRepository.findById(childId).get();
    }

    @Override
    public Iterable<ChildOfEmployee> findByAgeLessThan(int ageOfChild) {
        return childRepository.findByAgeOfChildLessThan(ageOfChild);
    }

    @Override
    public Iterable<ChildOfEmployee> sortByAgeOfChild() {
        return childRepository.findAll(Sort.by(Sort.Direction.ASC, "ageOfChild"));
    }

    @Override
    public Iterable<ChildOfEmployee> sortByAgeOfChildDesc() {
        return childRepository.findAll(Sort.by(Sort.Direction.DESC, "ageOfChild"));
    }

    @Override
    public Iterable<ChildOfEmployee> findAllByOrderByEmployeeSurname() {
        return childRepository.findAllByOrderByEmployeeSurname();
    }
}