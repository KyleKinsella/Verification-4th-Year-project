package cm;

public class StaffCalculation implements RateStrategy {
    @Override
    public double calculate(double totalCost) {
        return Math.max(totalCost, 16.00);
    }
}
