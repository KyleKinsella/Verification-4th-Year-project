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
        StaffCalculation staffCal = new StaffCalculation();
        assertEquals(16.00, staffCal.calculate(20.00), 0.01);
    }

    @Test
    void testManagementCalculation() {
        ManagementCalculation managementCal = new ManagementCalculation();
        assertEquals(4.00, managementCal.calculate(3.00), 0.01);
    }

    @Test
    void testStudentCalculation() {
        StudentCalculation studentCal = new StudentCalculation();
        assertEquals(8.88, studentCal.calculate(10.00), 0.01);
    }
}
