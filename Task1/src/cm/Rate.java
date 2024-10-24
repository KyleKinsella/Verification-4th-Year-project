import java.math.BigDecimal;
import java.util.ArrayList;

public class Rate {
    public Rate(String carParkKind, ArrayList<Period> reducedPeriods, ArrayList<Period> normalPeriods, BigDecimal normalRate, BigDecimal reducedRate) {
    }

    public BigDecimal calculate(Period period) {
        return new BigDecimal("0.01");
    }
}