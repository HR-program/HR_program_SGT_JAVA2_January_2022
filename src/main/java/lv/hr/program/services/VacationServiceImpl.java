package lv.hr.program.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.hr.program.model.Vacation;
import lv.hr.program.repositories.VacationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

//@Service
//@RequiredArgsConstructor
//@Transactional
//@Slf4j
//public class VacationServiceImpl implements VacationService {

//    private final VacationRepository vacationRepository;
//
//    @Override
//    public int countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate(LocalDate dateBefore, LocalDate dateAfter) {
//        int daysBetween = (int) DAYS.between(dateBefore, dateAfter);
//        int vacationDays = (int) (daysBetween / 30 * 1.67);
//        return vacationDays;
//    }

    // In the loop for starting from Empl. start date till  the end of every year call the method @countVacationDaysBetweenEmployeeStartWorkDateAndCurrentDate@
    // Put the result inside HashMap where key equals to year and value equals to vacation days
    // Return the HashMap.
    // Employer start date and retrieve the year from start date.
    // Retrieve full year of the current date.
    // Calculate from employee start date till the end of that year, then from the beginning of the current year till the end of the current year.



//    @Override
//    public List<LocalDate> countBusinessDaysBetweenEmployeeStartWorkDateAndCurrentDate(final LocalDate startDate,
//                                                                                       final LocalDate endDate,
//                                                                                       final Optional<List<LocalDate>> holidays) {
//        if (startDate == null || endDate == null) {
//            throw new IllegalArgumentException("Invalid method argument(s) to countBusinessDaysBetween" +
//                    " (" + startDate + "," + endDate + "," + holidays + ")");
//        }
//
//        Predicate<LocalDate> isHoliday = date -> holidays.isPresent() && holidays.get().contains(date);
//
//        Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
//                || date.getDayOfWeek() == DayOfWeek.SUNDAY;
//
//        List<LocalDate> businessDays = startDate.datesUntil(endDate)
//                .filter(isWeekend.or(isHoliday).negate())
//                .collect(Collectors.toList());
//
//        return businessDays;
//    }
//
//    public static Calendar vacationChristmasDay(int nYear) {
//        int nMonth = 11; //December
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(nYear, nMonth, 25);
//        return calendar;
//    }
//
//    public static Calendar christmasDayObserved(int nYear) {
//        int nX;
//        int nMonth = 11; // December
//        Calendar calendar;
//
//        calendar = Calendar.getInstance();
//        calendar.set(nYear, nMonth, 25);
//        nX = calendar.get(Calendar.DAY_OF_WEEK);
//        switch (nX) {
//            case 0: {// Sunday
//                calendar = Calendar.getInstance();
//                calendar.set(nYear, nMonth, 26);
//                return calendar;
//            }
//            case 1: // Monday
//            case 2: // Tuesday
//            case 3: // Wednesday
//            case 4: // Thrusday
//            case 5: { // Friday
//                calendar = Calendar.getInstance();
//                calendar.set(nYear, nMonth, 25);
//                return calendar;
//            }
//            default: {
//                // Saturday
//                calendar = Calendar.getInstance();
//                calendar.set(nYear, nMonth, 24);
//                return calendar;
//            }
//        }
//    }
//
//    public static Calendar easterMonday(int nYear) {
//        int nEasterMonth = 0;
//        int nEasterDay = 0;
//        int nMonthMarch = 2; // March
//        int nMonthApril = 3; // April
//        Calendar cEasterSunday = EasterSunday(nYear);
//        nEasterMonth = cEasterSunday.get(Calendar.MONTH);
//        nEasterDay = cEasterSunday.get(Calendar.DAY_OF_MONTH);
//        if (nEasterMonth == nMonthMarch || nEasterDay == 31) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.set(nYear, nMonthApril, 1);
//            return calendar;
//        } else {
//            Calendar cal = Calendar.getInstance();
//            cal.set(nYear, nEasterMonth, ++nEasterDay);
//            return cal;
//        }
//    }
//
//    public static Calendar EasterSunday(int nYear) {
//        int nA = 0;
//        int nB = 0;
//        int nC = 0;
//        int nD = 0;
//        int nE = 0;
//        int nF = 0;
//        int nG = 0;
//        int nH = 0;
//        int nI = 0;
//        int nK = 0;
//        int nL = 0;
//        int nM = 0;
//        int nP = 0;
//        int nEasterMonth = 0;
//        int nEasterDay = 0;
//
//        // Calculate Easter
//        if (nYear < 1900) {
//            // if year is in java format put it into standard
//            // format for the calculation
//            nYear += 1900;
//        }
//        nA = nYear % 19;
//        nB = nYear / 100;
//        nC = nYear % 100;
//        nD = nB / 4;
//        nE = nB % 4;
//        nF = (nB + 8) / 25;
//        nG = (nB - nF + 1) / 3;
//        nH = (19 * nA + nB - nD - nG + 15) % 30;
//        nI = nC / 4;
//        nK = nC % 4;
//        nL = (32 + 2 * nE + 2 * nI - nH - nK) % 7;
//        nM = (nA + 11 * nH + 22 * nL) / 451;
//
//        //  [3=March, 4=April]
//        nEasterMonth = (nH + nL - 7 * nM + 114) / 31;
//        --nEasterMonth;
//        nP = (nH + nL - 7 * nM + 114) % 31;
//
//        // Date in Easter Month.
//        nEasterDay = nP + 1;
//
//        // Incorrect for our earlier correction.
//        nYear -= 1900;
//
//        // Populate the date object...
//        Calendar cal = Calendar.getInstance();
//        cal.set(nYear, nEasterMonth, nEasterDay);
//        return cal;
//    }
//
//    public static Calendar NewYearsDay(int nYear) {
//        // January 1st
//        int nMonth = 0; // January
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(nYear, nMonth, 1);
//
//        return cal;
//    }
//
//    public static Calendar NewYearsDayObserved(int nYear) {
//        int nX;
//        int nMonth = 0;     // January
//        int nMonthDecember = 11;  // December
//
//        Calendar cal = Calendar.getInstance();
//        cal.set(nYear, nMonth, 1);
//
//        nX = cal.get(Calendar.DAY_OF_WEEK);
//
//        if (nYear > 1900)
//            nYear -= 1900;
//
//        switch (nX) {
//            case 0: // Sunday
//                cal = Calendar.getInstance();
//                cal.set(nYear, nMonth, 2);
//                return cal;
//            case 1: // Monday
//            case 2: // Tuesday
//            case 3: // Wednesday
//            case 4: // Thursday
//            case 5: // Friday
//                cal = Calendar.getInstance();
//                cal.set(nYear, nMonth, 1);
//                return cal;
//            default:
//                // Saturday, then observe on friday of previous year
//                cal = Calendar.getInstance();
//                cal.set(--nYear, nMonthDecember, 31);
//                return cal;
//        }
//    }
//
//    @Override
//    public Vacation create(Vacation vacation) {
//        return null;
//    }
//}
