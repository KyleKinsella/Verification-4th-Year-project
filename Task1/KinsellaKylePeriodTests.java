import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KinsellaKylePeriodTests {

    // below are valid tests for Period constructor
    @Test
    void validStartHourAndEndHour() {
        int start = 1;
        int end = 5;
        Period period = new Period(start, end);

        assertEquals(4, period.duration());
    }


    @Test
    void validPeriodObject() {
        int start = 2;
        int end = 5;

        Period period = new Period(start, end);
        assertNotNull(period);
    }

    @Test
    void startHourGreaterThanZero() {
        int start = 2;
        int end = 8;
        Period period = new Period(start, end);

        assertEquals(6, period.duration());
    }

    @Test
    void endHourGreaterThanZero() {
        int start = 4;
        int end = 7;
        Period period = new Period(start, end);

        assertEquals(3, period.duration());
    }

    @Test
    void periodNotEqualToNull() {
        int start = 1;
        int end = 5;
        Period period = new Period(start, end);

        assertNotEquals(true, period);
    }
    // end of valid tests for Period constructor
















    @Test
    void checkSameTime() {
        int start = 4;
        int end = 4;

        Period p1 = new Period(start, end);

        assertEquals(p1.duration(), 0);
    }

    @Test
    void boundaryValuesInvalidObject() {
        int start = -2;
        int end = -5;

        Period period = new Period(start, end);

        assertEquals(period.duration(), -7);
    }

    @Test
    void invalidOrder() {
        int end = 6;
        int start = 2;

        Period period = new Period(end, start);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });

        assertEquals(-4, e.getMessage());
    }
    // end of test's for Period constructor

    @Test
    void invalidPeriodConstructor() {
        int start = 2;
        int end = 5;

        Period period = null;

        assertNotNull(period);
    }





















    // test's for duration method
    @Test
    void validStartAndEndPeriod() {
        int start = 4;
        int end = 6;

        Period p1 = new Period(start, end);

        assertEquals(p1.duration(), 2);
    }

    @Test
    void invalidPeriod() {
        Period p1 = new Period(-1, 0);

        assertEquals(p1.duration(), -1);
    }

    @Test
    void invalidDuration() {
        int start = 5;
        int end = 12;

        Period period = new Period(start, end);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });

        assertEquals(period.duration(), -7, e.getMessage());
    }

    @Test
    void startAndEndHourNotEqualDuration() {
        int start = 2;
        int end = 2;

        Period period = new Period(start, end);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });

        assertEquals(period.duration(), 6, e.getMessage());
    }


    @Test
    void startHourNotEqualDuration() {
        int start = 3;
        int end = 2;

        Period period = new Period(start, end);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });

        assertEquals(period.duration(), 2, e.getMessage());
    }


    @Test
    void endHourNotEqualDuration() {
        int start = 2;
        int end = 3;

        Period period = new Period(start, end);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });

        assertEquals(period.duration(), 1, e.getMessage());
    }
    // end of test's for duration method




    // test's for Overlaps(Period period) method
    @Test
    void validOverlapsMethod() {
        Period period1 = new Period(1, 2);
        Period period2 = new Period(2, 4);

        assertEquals(period1.overlaps(period2), true);
    }

    @Test
    void invalidOverlapsMethod() {
        Period period1 = new Period(1, 2);
        Period period2 = new Period(10, 12);

        assertEquals(period1.overlaps(period2), false);
    }

    @Test
    void periodOneEqualToPeriodTwo() {
        Period period1 = new Period(1, 2);
        Period period2 = new Period(1, 2);

        assertEquals(period1.equals(period2), true);
    }

    // end of test's for Overlaps(Period period) method
}
