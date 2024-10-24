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
