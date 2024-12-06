package cm;

public class RateCalculatorTest {
    private final RateCalculator calculator = new RateCalculator();

    @Test
    public void testVisitorRateCalculation() {
        calculator.setStrategy(new VisitorRateStrategy());
        assertEquals(2.50, calculator.calculate(15.00), 0.01);
        assertEquals(0.00, calculator.calculate(8.00), 0.01);
    }
}
