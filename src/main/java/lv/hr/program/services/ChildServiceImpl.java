package lv.hr.program.services;

import lv.hr.program.model.ChildOfEmployee;
import lv.hr.program.model.Employee;
import lv.hr.program.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//    @Override
//    public ResponseEntity<ChildOfEmployee> addNewChildByParent (@PathVariable(value = "employeeId") Long id,
//                                                                @RequestBody ChildOfEmployee childOfEmployeeRequest) {
//    public void addChildByParent(ChildOfEmployee childOfEmployee, Long id) {
//        ChildOfEmployee child = employeeRepository.findById(id).map(tutorial -> {
//                    childOfEmployeeRequest.setEmployee(employee);
//                    return childRepository.save(childOfEmployeeRequest);
//        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
//
//            return new ResponseEntity<>(chid, HttpStatus.CREATED);
//    }

//    @Override
//    public void addChildByParent(ChildOfEmployee childOfEmployee, Long id) {
//        ChildOfEmployee child = employeeRepository.findById(id).map(employee -> {
//            childOfEmployee.setEmployee(employee);
//            return childRepository.save(childOfEmployee);
//        }}


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
        return null;
    }


//    @Override
//    public Iterable<ChildOfEmployee> findByEmployeeId(Long id) {
//        return childRepository.findByEmployeeId(id);
//    }
}

//    @Override
//    public ResponseEntity<ChildOfEmployee> findByEmployeeId(Long id) {
//        return (ResponseEntity<ChildOfEmployee>) childRepository.findByEmployeeId(id);
//    }



