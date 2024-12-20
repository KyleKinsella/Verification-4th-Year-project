package cm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KinsellaKylePeriodTests2 {
    // below are valid tests for Period constructor
    @Test
    void validStartHourAndEndHour() {
        int start = 1;
        int end = 5;
        Period period = new Period(start, end);
        assertNotNull(period);
    }
    @Test
    void validPeriodObject() {
        int start = 3;
        int end = 5;
        Period period = new Period(start, end);
        assertNotNull(period);
    }
    @Test
    void startHourGreaterThanZero() {
        int start = 2;
        int end = 8;
        Period period = new Period(start, end);
        assertNotNull(period);
    }
    @Test
    void endHourGreaterThanZero() {
        int start = 4;
        int end = 7;
        Period period = new Period(start, end);
        assertNotNull(period);
    }
    @Test
    void startHourGreaterThan12() {
        int start = 13;
        int end = 14;
        Period period = new Period(start, end);
        assertNotNull(period);
    }
    @Test
    void endHourGreaterThan12() {
        int start = 13;
        int end = 18;
        Period period = new Period(start, end);
        assertNotNull(period);
    }
    // end of valid tests for Period constructor

    //invalid period constructor tests:
    @Test
    void invalidPeriodObject() {
        int start = -1;
        int end = 0;
        Period p1 = new Period(start, end);
        // no need for an assert here due to the p1 period object having an error
    }
    @Test
    void checkSameTime() {
        int start = 4;
        int end = 4;
        Period p1 = new Period(start, end);
        // no need for an assert here due to the p1 period object having an error
    }
    @Test
    void startHourGreaterThan24() {
        int start = 26;
        int end = 2;
        Period period = new Period(start, end);
        // no need for an assert here due to the period object having an error
    }
    @Test
    void startHourLessThanZero() {
        int start = -1;
        int end = 5;
        Period period = new Period(start, end);
        // no need for an assert here due to the period object having an error
    }
    @Test
    void startHourLessThanEndHour() {
        int start = 5;
        int end = 1;
        Period period = new Period(start, end);
        // no need for an assert here due to the period object having an error
    }
    @Test
    void invalidOrder() {
        int end = 6;
        int start = 2;
        Period period = new Period(end, start);
        // no need for an assert here due to the period object having an error
    }
    // end of invalid tests for Period constructor

    // below is a valid test for the duration method
    @Test
    void validStartAndEndPeriod() {
        int start = 4;
        int end = 5;
        Period p1 = new Period(start, end);
        assertEquals(1, p1.duration());
    }
    // end of valid test for the duration method

    // below is an invalid test for the duration method
    @Test
    void invalidDuration() {
        int start = -5;
        int end = -12;
        Period period = new Period(start, end);
        // no need for an assert here due to the period object having an error
    }
    // end of invalid tests for the duration method

    // below are valid tests for the overlaps method
    @Test
    void validOverlapPeriod() {
        Period period1 = new Period(1, 2);
        Period period2 = new Period(2, 4);
        assertEquals(period1.overlaps(period2), false);
    }
    @Test
    void validBoundary() {
        Period period1 = new Period(1, 0);
        Period period2 = new Period(0, 1);
        assertEquals(period1.overlaps(period2), false);
    }
    @Test
    void startHourAndEndHourEqualPeriod1() {
        int start = 1;
        int end = 5;
        Period period1 = new Period(start, end);
        Period period2 = new Period(2, 3);
        assertEquals(period1.overlaps(period2), true);
    }
    @Test
    void endHourAndStartHourEqualPeriod1() {
        int start = 4;
        int end = 9;
        Period period1 = new Period(start, end);
        Period period2 = new Period(2, 3);
        assertEquals(period1.overlaps(period2), false); // should be false
    }
    @Test
    void startHourAndEndHourEqualPeriod2() {
        int start = 1;
        int end = 3;
        Period period1 = new Period(4, 9);
        Period period2 = new Period(start, end);
        assertEquals(period1.overlaps(period2), false);
    }
    @Test
    void endHourAndStartHourEqualPeriod2() {
        int start = 6;
        int end = 9;
        Period period1 = new Period(4, 9);
        Period period2 = new Period(start, end);
        assertEquals(period1.overlaps(period2), true);
    }
    // i forgot to write this test for task 1 but i have wrote it now for task 2
    @Test
    void period1IsEqualToPeriod2() {
        Period period1 = new Period(2, 3);
        Period period2 = new Period(2, 3);
        assertEquals(period1.overlaps(period2), true);
    }
    // end of valid tests for the overlaps method

    // below are invalid tests for the overlaps method
    @Test
    void invalidOverlapPeriod() {
        Period period1 = new Period(2, 4);
        Period period2 = new Period(8, 12);
        assertEquals(period1.overlaps(period2), false);
    }
    @Test
    void period1GreaterThanPeriod2() {
        Period period1 = new Period(10, 11);
        Period period2 = new Period(13, 15);
        assertEquals(period1.overlaps(period2), false);
    }
    @Test
    void samePeriodTimes() {
        Period period1 = new Period(1, 2);
        Period period2 = new Period(1, 2);
        assertEquals(period1.equals(period2), false);
    }
    // end of invalid tests for the overlaps method

    //below are my white / glass box tests for the period class
    @Test
    void occurencesTest() {
        Period period1 = new Period(1, 5);
        List<Period> periodList = new ArrayList<>();
        int occur = period1.occurences(periodList);
        assertEquals(0, occur);
    }
    @Test
    void occurencesTestWithValues() {
        Period period1 = new Period(4, 8);
        Period period2 = new Period(1, 5);
        Period testPeriod = new Period(5, 9);

        List<Period> periodList = Arrays.asList(period1, period2);
        assertEquals(3, testPeriod.occurences(periodList));
    }
    @Test
    void occurancesNotEqualToHourAgain() {
        Period period1 = new Period(2, 7);
        Period period2 = new Period(5, 10);
        Period period3 = new Period(0, 4);
        Period testPeriod = new Period(1, 5);

        List<Period> periodList = Arrays.asList(period1, period2, period3);
        assertEquals(4, testPeriod.occurences(periodList));
    }
}
