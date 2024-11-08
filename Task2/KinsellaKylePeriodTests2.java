import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KinsellaKylePeriodTests2 {

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



    // below are invalid tests for Period constructor
    @Test
    void invalidPeriodObject() {
        int start = 2;
        int end = 5;

        Period period = null;

        assertNotNull(period);
    }

    @Test
    void checkSameTime() {
        int start = 4;
        int end = 4;

        Period p1 = new Period(start, end);

        assertEquals(p1.duration(), 0);
    }

    @Test
    void startHourGreaterThan24() {
        int start = 26;
        int end = 2;
        Period period = new Period(start, end);

        assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });
    }

    @Test
    void startHourLessThanZero() {
        int start = -1;
        int end = -5;
        Period period = new Period(start, end);

        assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });
    }

    @Test
    void endHourGreaterThanStartHour() {
        int start = 1;
        int end = 5;
        Period period = new Period(start, end);

        assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });
    }

    @Test
    void startHourLessThanEndHour() {
        int start = 5;
        int end = 1;
        Period period = new Period(start, end);

        assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });
    }

    @Test
    void startHourGreaterThan12() {
        int start = 13;
        int end = 14;
        Period period = new Period(start, end);

       assertThrows(IllegalArgumentException.class, () -> {
          period.duration();
       });
    }

    @Test
    void endHourGreaterThan12() {
        int start = 13;
        int end = 18;
        Period period = new Period(start, end);

        assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });
    }


    @Test
    void invalidOrder() {
        int end = 6;
        int start = 2;

        Period period = new Period(end, start);

        assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });
    }
    // end of invalid tests for Period constructor





    // below is a valid test for the duration method
    @Test
    void validStartAndEndPeriod() {
        int start = 4;
        int end = 5;

        Period p1 = new Period(start, end);

        assertEquals(p1.duration(), 1);
    }
    // end of valid test for the duration method


    // below is an invalid test for the duration method
    @Test
    void invalidDuration() {
        int start = -5;
        int end = -12;
        Period period = new Period(start, end);

        assertThrows(IllegalArgumentException.class, () -> {
            period.duration();
        });
    }
    // end of invalid tests for the duration method







    // below are valid tests for the overlaps method
    @Test
    void validOverlapPeriod() {
        Period period1 = new Period(1, 2);
        Period period2 = new Period(2, 4);

        assertEquals(period1.overlaps(period2), true);
    }

    @Test
    void validBoundary() {
        Period period1 = new Period(1, 0);
        Period period2 = new Period(0, 1);

        assertEquals(period1.overlaps(period2), true);
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

        assertEquals(period1.overlaps(period2), true);
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
}
