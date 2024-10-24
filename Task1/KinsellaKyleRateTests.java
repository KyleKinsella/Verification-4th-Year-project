import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KinsellaKyleRateTests {

    // below are tests for Rate constructor
    @Test
    void validRateObject() {

        String kind = "";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = BigDecimal.valueOf(0.5);
        BigDecimal reducedRate = BigDecimal.valueOf(0.5);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);
        assertNotNull(rate);
    }

    @Test
    void invalidRateObject() {
        String kind = "";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = BigDecimal.valueOf(0.5);
        BigDecimal reducedRate = BigDecimal.valueOf(0.5);

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





















    // below are tests for calculate method
    @Test
    void validCalculation() {
        int start = 5;
        int end = 9;
        Period period = new Period(start, end);


        String kind = "";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = BigDecimal.valueOf(0.5);
        BigDecimal reducedRate = BigDecimal.valueOf(0.5);

        Rate rate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertEquals(rate.calculate(period), rate);
    }

    @Test
    void invalidCalculation() {
        int start = 2;
        int end = 4;
        Period period = new Period(start, end);

        String kind = "";
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        BigDecimal normalRate = BigDecimal.valueOf(0.5);
        BigDecimal reducedRate = BigDecimal.valueOf(0.5);

        Rate rate = null;

        assertNotNull(rate.calculate(period));
    }
}
