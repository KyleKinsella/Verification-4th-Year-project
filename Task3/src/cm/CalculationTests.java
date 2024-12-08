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
    void testVisitor() {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        normalPeriods.add(new Period(8, 12));
        reducedPeriods.add(new Period(12, 14));

        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = BigDecimal.valueOf(3.00);
        BigDecimal reducedRate = BigDecimal.valueOf(2.00);
        Rate rate = new Rate(kind, normalPeriods, reducedPeriods, normalRate, reducedRate);

        Period period = new Period(8, 14);
        BigDecimal result = rate.calculate(period);

        assertEquals(BigDecimal.valueOf(0), result);
    }

    @Test
    public void testStaffMaximumValue() {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        normalPeriods.add(new Period(8, 18));

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = BigDecimal.valueOf(3.00);
        BigDecimal reducedRate = BigDecimal.valueOf(2.00);
        Rate staffRate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Calculate cost for a periodStay
        Period periodStay = new Period(8, 18);
        BigDecimal result = staffRate.calculate(periodStay);

        assertEquals(BigDecimal.valueOf(16.00), result);
    }

    @Test
    public void testStudentDiscountAboveAmount() {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        normalPeriods.add(new Period(8, 12));
        reducedPeriods.add(new Period(12, 14));

        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = BigDecimal.valueOf(2.00);
        BigDecimal reducedRate = BigDecimal.valueOf(1.50);
        Rate studentRate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Calculate cost for a periodStay
        Period periodStay = new Period(8, 14);
        BigDecimal result = studentRate.calculate(periodStay);

        assertEquals(BigDecimal.valueOf(9.6), result);
    }

    @Test
    public void testManagementMinimum() {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        normalPeriods.add(new Period(8, 18));

        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = BigDecimal.valueOf(3.00);
        BigDecimal reducedRate = BigDecimal.valueOf(2.00);
        Rate managementRate = new Rate(kind, reducedPeriods, normalPeriods, normalRate, reducedRate);

        // Calculate cost for a periodStay
        Period periodStay = new Period(8, 18);
        BigDecimal result = managementRate.calculate(periodStay);

        assertEquals(BigDecimal.valueOf(30.00), result);
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
