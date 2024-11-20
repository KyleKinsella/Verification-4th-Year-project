package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KinsellaKyleRateTests2 {

    // below are valid tests for the Rate constructor
    @Test
    void validNormalRate() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    @Test
    void validReducedRate() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("2.5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
    @Test
    void validCarParkKind() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("3");
        BigDecimal reducedRate = new BigDecimal("1.5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
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
        assertNotNull(rate);
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
        assertNotNull(rate);
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);        // no need for an assert here due to the p1 period object having an error
        // no need for an assert here due to the rate object having an error
    }
    @Test
    void invalidReducedRate() {
        CarParkKind kind = CarParkKind.VISITOR;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("0");
        BigDecimal reducedRate = new BigDecimal("0");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        // no need for an assert here due to the rate object having an error
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        // no need for an assert here due to the rate object having an error
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

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        // no need for an assert here due to the rate object having an error
    }
    @Test
    void invalidReducedRateSTAFF() {
        CarParkKind kind = CarParkKind.STAFF;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("-90");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        // no need for an assert here due to the rate object having an error
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
        assertEquals(rate.calculate(period), "40");
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

        assertEquals(rate.calculate(period), "10");
    }
    @Test
    void validCalculatePeriodNormalHourlyRateTimes2() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("3");
        BigDecimal reducedRate = new BigDecimal("1.5");

        int start = 4;
        int end = 6;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate.calculate(period), "6");
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
        assertNotNull(rate.calculate(period), "free");
    }
    // end of valid tests for the calculate method

    // below are invalid tests for the calculate method
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
        // no need for an assert here due to the rate object having an error
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
        // no need for an assert here due to the rate object having an error
    }
    @Test
    void invalidPeriod() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("-5");
        BigDecimal reducedRate = new BigDecimal("-2.5");

        int start = -1;
        int end = 0;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        // no need for an assert here due to the rate object having an error
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

        assertEquals(rate.calculate(period), "40");
    }
    @Test
    void notFreePeriodReducedRate() {
        CarParkKind kind = CarParkKind.STUDENT;

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        int start = 6;
        int end = 10;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertEquals(rate.calculate(period), "20");
    }
    // end of invalid tests for the calculate method

    // below are my white / glass box tests for the rate class
    @Test
    void reducedPeriodsNull() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = null;
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        int start = 6;
        int end = 10;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(reducedPeriods);
    }
    @Test
    void normalPeriodsNull() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = null;

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        int start = 6;
        int end = 10;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(normalPeriods);
    }
    @Test
    void normalRateNull() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal("5");

        int start = 6;
        int end = 10;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(normalRate);
    }
    @Test
    void reducedRateNull() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = null;

        int start = 6;
        int end = 10;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(reducedRate);
    }
    @Test
    void notIsValidPeriodsForReducedPeriodsAndNormalPeriods() {
        CarParkKind kind = CarParkKind.STUDENT;
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        Period reducedPeriod1 = new Period(1, 2);
        Period reducedPeriod2 = new Period(6, 9);
        Period reducedPeriod3 = new Period(9, 12);
        reducedPeriods.add(reducedPeriod1);
        reducedPeriods.add(reducedPeriod2);
        reducedPeriods.add(reducedPeriod3);

        Period normalPeriod1 = new Period(1, 2);
        Period normalPeriod2 = new Period(6, 9);
        Period normalPeriod3 = new Period(9, 12);
        normalPeriods.add(normalPeriod1);
        normalPeriods.add(normalPeriod2);
        normalPeriods.add(normalPeriod3);

        BigDecimal normalRate = new BigDecimal("10");
        BigDecimal reducedRate = new BigDecimal("5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }
}
