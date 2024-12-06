package cm;

public class VisitorCalculation implements RateStrategy {
    @Override
    public double calculate(double totalCost) {
        if (totalCost <= 10.00) {
            // free
            return 0.00;
        }
        return (totalCost - 10.00) * 0.50;
    }
}
