package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTests {

    @Test
    public void testVisitorForFree() {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        normalPeriods.add(new Period(8, 10));
        reducedPeriods.add(new Period(10, 12));

        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = BigDecimal.valueOf(2.50);
        BigDecimal reducedRate = BigDecimal.valueOf(1.50);
        Rate visitorRate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Calculate cost for a periodStay
        Period periodStay = new Period(8, 12);
        BigDecimal result = visitorRate.calculate(periodStay);
        
        assertEquals(BigDecimal.ZERO, result); // Should be free
    }

    @Test
    void testVisitorCalculation() {
        VisitorCalculation visitorCal = new VisitorCalculation();
        assertEquals(2.50, visitorCal.calculate(15.00), 0.01);
    }

    @Test
    void testStaffCalculation() {
        StaffCalculation staff = new StaffCalculation();
        assertEquals(16.00, staff.calculate(20.00), 0.01);
    }

    @Test
    void testManagementCalculation() {
        ManagementCalculation management = new ManagementCalculation();
        assertEquals(4.00, management.calculate(3.00), 0.01);
    }

    @Test
    void testStudentCalculation() {
        StudentCalculation student = new StudentCalculation();
        assertEquals(5.00, student.calculate(5.00), 0.01);
    }
}
