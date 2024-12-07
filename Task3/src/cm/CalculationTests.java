package cm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTests {

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
}
