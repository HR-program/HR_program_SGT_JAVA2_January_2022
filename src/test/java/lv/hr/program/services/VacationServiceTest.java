package lv.hr.program.services;

import lv.hr.program.model.Vacation;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VacationServiceTest {

    private Vacation vacation;

    @Before
    public void setUp() throws Exception {
        vacation = new Vacation();
    }

    @Test
    public void countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDateIfStartedMoreThanAYearAgo() {
        LocalDate workStartDate = LocalDate.of(2019, 1, 1);
        HashMap<Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2019, 20);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears
                (workStartDate, LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDateIfStartedLessThanAYearAgo() {
        LocalDate workStartDate = LocalDate.of(2021, 7, 1);
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2021, 10);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(workStartDate, LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDateIfStartedThisYear() {
        LocalDate workStartDate = LocalDate.of(2022, 1, 1);
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2022, 0);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(workStartDate, LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDateIfStartedToday() {
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2022, 0);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(LocalDate.now(), LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDateIfWrongDateAfterToday() {
        LocalDate workStartDate = LocalDate.of(2022, 7, 1);
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2022, 0);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(workStartDate, LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void returnCalculatedVacationDaysForAllYearsIfStartedTwentyNineteenJanuaryFirst() {
        LocalDate workStartDate = LocalDate.of(2019, 1, 1);
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2019, 20);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(workStartDate, LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void returnCalculatedVacationDaysForAllYearsIfStartedTwentyTwentyOneJulyFirst() {
        LocalDate workStartDate = LocalDate.of(2021, 7, 1);
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2021, 10);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(workStartDate, LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void returnCalculatedVacationDaysForAllYearsIfStartedToday() {
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2022, 0);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(LocalDate.now(), LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void returnCalculatedVacationDaysForAllYearsIfStartedWrongDateAfterToday() {
        LocalDate workStartDate = LocalDate.of(2023, 7, 1);
        HashMap <Integer, Integer> expectedResult = new HashMap<>();
        expectedResult.put(2023, 0);
        HashMap <Integer, Integer> actualResult = vacation.returnCalculatedVacationDaysForAllYears(workStartDate, LocalDate.now());
        assertEquals(expectedResult, actualResult);
    }
}