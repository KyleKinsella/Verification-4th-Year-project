package cm;

import java.math.BigDecimal;

public class StaffCalculation implements IStaffBehaviour {

    public double calculate(BigDecimal kindOfRate) {
        int value = kindOfRate.intValue();
        int n = (value-10);
        return 0.5*n;
    }

    public static void main(String[] args) {
        StaffCalculation sc = new StaffCalculation();
        BigDecimal bd  = new BigDecimal("15");
        System.out.println("Staff Calculation: " + sc.calculate(bd));
    }
}
