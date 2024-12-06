package cm;

public class RateCalculator {
    private RateStrategy strat;

    public void setStrategy(RateStrategy strat) {
        this.strat = strat;
    }

    public double calculate(double totalCost) {
        if (strat == null) {
            throw new IllegalArgumentException("Rate strat not set");
        }
        return strat.calculate(totalCost);
    }
}
