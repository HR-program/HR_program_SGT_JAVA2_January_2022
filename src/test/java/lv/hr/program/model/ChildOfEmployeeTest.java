package lv.hr.program.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ChildOfEmployeeTest {
    private int ageOfChild;


    @Test
    public void shouldGetAgeOfChild() {
        ChildOfEmployee childOfEmployee = new ChildOfEmployee();

        childOfEmployee.setChildDateOfBirth(LocalDate.of(2007, 01, 01));
        int ageOfChild = childOfEmployee.getAgeOfChild();
        Assertions.assertEquals(15,ageOfChild);


    }
}



