package cm;

public class ManagementCalculation implements RateStrategy {
    @Override
    public double calculate(double totalCost) {
        return Math.max(totalCost, 4.00);
    }
}
