import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KinsellaKyleRateTests2 {

    // below are valid tests for the Rate constructor
    @Test
    void validRateObject() {

        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = new BigDecimal("");
        BigDecimal reducedRate = new BigDecimal("");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }

    @Test
    void invalidRateObject() {
        CarParkKind kind = CarParkKind.VISITOR;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = new BigDecimal("");
        BigDecimal reducedRate = new BigDecimal("");

        Rate rate = null;
        assertNotNull(rate);
    }


    @Test
    void validNormalRate() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        int start = 5;
        int end = 10;

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period period = new Period(start, end);

        assertEquals("10", rate.calculate(period));
    }


    @Test
    void validReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("2.5");

        int start = 5;
        int end = 10;

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period period = new Period(start, end);

        assertEquals("2.5", rate.calculate(period));
    }

    @Test
    void validCarParkKind() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("3");
        BigDecimal reducedRate = new BigDecimal("1.5");

        int start = 5;
        int end = 10;

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        Period period = new Period(start, end);

        assertEquals(true, kind);
    }

    @Test
    void validReducedRateArrayList() {
        CarParkKind kind = CarParkKind.STUDENT;

        Period period1 = new Period(1, 3);
        Period period2 = new Period(2, 4);
        Period period3 = new Period(5, 10);
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(period1);
        reducedPeriods.add(period2);
        reducedPeriods.add(period3);

        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertEquals(reducedPeriods, reducedPeriods);
    }

    @Test
    void validNormalRateArrayList() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();

        Period period1 = new Period(5, 10);
        Period period2 = new Period(4, 8);
        Period period3 = new Period(1,10);
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(period1);
        normalPeriods.add(period2);
        normalPeriods.add(period3);

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertEquals(normalPeriods, normalPeriods);
    }
    // end of valid tests for the Rate constructor



    // below are invalid tests for the Rate constructor
    @Test
    void invalidNormalRate() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("-1");
        BigDecimal reducedRate = new BigDecimal("-0.5");

        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });
    }


    @Test
    void invalidReducedRate() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("0");
        BigDecimal reducedRate = new BigDecimal("0");

        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });
    }

    @Test
    void invalidReducedRateArrayList() {
        CarParkKind kind = CarParkKind.STUDENT;


        Period period1 = new Period(-1, -2);
        Period period2 = new Period(-42, -50);
        Period period3 = new Period(-90, 55);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(period1);
        reducedPeriods.add(period2);
        reducedPeriods.add(period3);

        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });
    }

    @Test
    void invalidNormalRateArrayList() {
        CarParkKind kind = CarParkKind.STUDENT;

        Period period1 = new Period(-1, 67);
        Period period2 = new Period(90, -90);
        Period period3 = new Period(65, -87);

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(period1);
        normalPeriods.add(period2);
        normalPeriods.add(period3);

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });
    }



    @Test
    void invalidReducedRateTwo() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("-90");

        assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });
    }
    // end of invalid tests for the Rate constructor






    // below are the valid tests for the calculate method
    @Test
    void validNormalRateCalculation() {

        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        int start = 1;
        int end = 5;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertEquals(40, rate.calculate(period));
    }

    @Test
    void validReducedRateCalculation() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("2.5");

        int start = 1;
        int end = 5;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertEquals(10, rate.calculate(period));
    }

    @Test
    void validFreePeriod() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("2");
        BigDecimal reducedRate = new BigDecimal("1");

        int start = 0;
        int end = 7;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertEquals(0, rate.calculate(period));
    }


    @Test
    void invalidNormalRateCalculation() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("-1");
        BigDecimal reducedRate = new BigDecimal("-0.5");

        int start = -1;
        int end = -4;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(period);
        });
    }

    @Test
    void invalidReducedRateCalculation() {
        CarParkKind kind = CarParkKind.STAFF;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("0");
        BigDecimal reducedRate = new BigDecimal("0");

        int start = 11;
        int end = 9;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(period);
        });
    }

    @Test
    void invalidPeriod() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("-5");
        BigDecimal reducedRate = new BigDecimal("-2.5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        int start = -1;
        int end = 0;
        Period period = new Period(start, end);

        assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(period);
        });
    }

    @Test
    void notFreePeriodNormalRate() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        int start = 6;
        int end = 10;
        Period period = new Period(start, end);

        assertEquals(40, rate.calculate(period));
    }

    @Test
    void notFreePeriodReducedRate() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        int start = 6;
        int end = 10;
        Period period = new Period(start, end);

        assertEquals(20, rate.calculate(period));
    }


    @Test
    void invalidCalculation() {
        int start = 2;
        int end = 4;
        Period period = new Period(start, end);

        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = new BigDecimal("");
        BigDecimal reducedRate = new BigDecimal("");

        Rate rate = null;

        assertNotNull(rate.calculate(period));
    }
    // end of invalid tests for the calculate method
}
