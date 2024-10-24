import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class KinsellaKyleRateTests {

    // below are valid tests for the Rate constructor
    @Test
    void validRateObject() {

        String kind = "";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = new BigDecimal("");
        BigDecimal reducedRate = new BigDecimal("");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }

    @Test
    void invalidRateObject() {
        String kind = "";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = new BigDecimal("");
        BigDecimal reducedRate = new BigDecimal("");

        Rate rate = null;
        assertNotNull(rate);
    }


    @Test
    void validNormalRate() {
        String kind = "Student";
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
        String kind = "Staff";
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
        String kind = "Management";
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
        String kind = "Student";

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
        String kind = "Student";

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
        String kind = "Visitor";

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("-1");
        BigDecimal reducedRate = new BigDecimal("-0.5");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });

        assertEquals(e.getMessage(), normalRate);
    }


    @Test
    void invalidReducedRate() {
        String kind = "Visitor";

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("0");
        BigDecimal reducedRate = new BigDecimal("0");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });

        assertEquals(e.getMessage(), reducedRate);
    }

    @Test
    void invalidReducedRateArrayList() {
        String kind = "Student";

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

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });

        assertEquals(e.getMessage(), reducedRate);
    }

    @Test
    void invalidNormalRateArrayList() {
        String kind = "Student";

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

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });

        assertEquals(e.getMessage(), normalPeriods);
    }

    @Test
    void invalidCarParkKind() {
        String kind = "Animals";

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("20");
        BigDecimal reducedRate = new BigDecimal("10");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });

        assertEquals(e.getMessage(), kind);
    }

    @Test
    void invalidReducedRateTwo() {
        String kind = "Staff";

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("-90");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });

        assertEquals(e.getMessage(), reducedRate);
    }
    // end of invalid tests for the Rate constructor






    // below are the valid tests for the calculate method
    @Test
    void validNormalRateCalculation() {

        String kind = "Student";
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
        String kind = "Staff";

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
        String kind = "Visitor";

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
        String kind = "Staff";

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("-1");
        BigDecimal reducedRate = new BigDecimal("-0.5");

        int start = -1;
        int end = -4;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(period);
        });

        assertEquals(e.getMessage(), period);
    }

    @Test
    void invalidReducedRateCalculation() {
        String kind = "Staff";

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("0");
        BigDecimal reducedRate = new BigDecimal("0");

        int start = 11;
        int end = 9;
        Period period = new Period(start, end);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(period);
        });

        assertEquals(e.getMessage(), period);
    }

    @Test
    void invalidPeriod() {
        String kind = "Student";

        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("-5");
        BigDecimal reducedRate = new BigDecimal("-2.5");

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        int start = -1;
        int end = 0;
        Period period = new Period(start, end);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(period);
        });

        assertEquals(e.getMessage(), period);
    }

    @Test
    void notFreePeriodNormalRate() {
        String kind = "Student";

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
        String kind = "Student";

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

        String kind = "";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = new BigDecimal("");
        BigDecimal reducedRate = new BigDecimal("");

        Rate rate = null;

        assertNotNull(rate.calculate(period));
    }
    // end of invalid tests for the calculate method
}
