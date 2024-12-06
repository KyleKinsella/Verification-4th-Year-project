package cm;

public class StudentCalculation implements RateStrategy {
    @Override
    public double calculate(double totalCost) {
        if (totalCost <= 5.50) {
            return totalCost;
        }
        return 5.50 + (totalCost - 5.50) * 0.75;
    }
}
