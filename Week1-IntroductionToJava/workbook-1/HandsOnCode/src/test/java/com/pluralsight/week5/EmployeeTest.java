package com.pluralsight.week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    /*
        private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;
     */

    @Test
    void punchIn_withValidTime_setsPunchInTime() {
        Employee employee = new Employee(1, "John Doe", "Department", 10.0, 40.0);
        double punchInTime = 20.0;

        employee.punchIn(punchInTime);

        assertEquals(punchInTime, employee.getPunchInTime());
    }

    @Test
    void punchIn_withNegativeTime_throwsAnError() {
        Employee employee = new Employee(1, "John Doe", "Department", 10.0, 40.0);
        double punchInTime = -20.0;

        try {
            employee.punchIn(punchInTime);
            fail("Time must be between 0 and 24");
        } catch (IllegalArgumentException e) {
            assertEquals("Time must be between 0 and 24", e.getMessage());
        }
//        assertThrows(IllegalArgumentException.class, () -> employee.punchIn(punchInTime));
    }

    @Test
    void punchIn_withInvalidTime_throwsAnError() {
        Employee employee = new Employee(1, "John Doe", "Department", 10.0, 40.0);
        double punchInTime = 30.0;

        try {
            employee.punchIn(punchInTime);
            fail("Time must be between 0 and 24");
        } catch (IllegalArgumentException e) {
            assertEquals("Time must be between 0 and 24", e.getMessage());
        }
//        assertThrows(IllegalArgumentException.class, () -> employee.punchIn(punchInTime));
    }


    @Test
    void punchOut_withValidTime_calculatesHoursWorked() {
        Employee employee = new Employee(1, "John Doe", "Department", 10.0, 0.0);
        double punchIn = 10.0;
        double punchOut = 15.0;
        double expectedHoursWorked = 5.0;

        employee.punchIn(punchIn);
        employee.punchOut(punchOut);

        assertEquals(expectedHoursWorked, employee.getHoursWorked());

    }

    @Test
    void punchOut_withInValidTime_throwsAnError() {
        Employee employee = new Employee(1, "John Doe", "Department", 10.0, 0.0);
        double punchIn = 10.0;
        double punchOut = -15.0;

        employee.punchIn(punchIn);
        assertThrows(IllegalArgumentException.class, () -> employee.punchOut(punchOut));
    }
}