package cm;

public class outputOfCalculations {
    public static void main(String[] args) {
        VisitorCalculation visitor = new VisitorCalculation();
        System.out.println("Visitor rate for 15.00 is: " + visitor.calculate(15.00));

        StaffCalculation staff = new StaffCalculation();
        System.out.println("Staff rate for 20.00 is: " + staff.calculate(20.00));

        ManagementCalculation management = new ManagementCalculation();
        System.out.println("Management rate for 3.00 is: " + management.calculate(3.00));

        StudentCalculation student = new StudentCalculation();
        System.out.println("Student rate for 10.00 is: " + student.calculate(10.00));
    }
}
