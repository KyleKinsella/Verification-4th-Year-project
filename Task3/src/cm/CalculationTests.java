package cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTests {

    @Test
    void testVisitorCalculation() {
        VisitorCalculation visitorCal = new VisitorCalculation();
        assertEquals(2.50, visitorCal.calculate(15.00), 0.01);
    }
}
