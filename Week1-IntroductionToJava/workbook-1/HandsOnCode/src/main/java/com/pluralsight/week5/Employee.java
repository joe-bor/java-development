package com.pluralsight.week5;

class Employee {
    private int employeeId;
    private String name;
    private String department;
    private float payRate;
    private float hoursWorked;

    public Employee(int employeeId, String name, String department, float payRate, float hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getTotalPay() {
        float overtimeHours = getOverTimeHours();
        float totalPay = 0f;

        if (overtimeHours > 0f) {
            totalPay = (payRate * 1.5f * overtimeHours) + (payRate * getRegularHours());
        } else {
            totalPay = payRate * getRegularHours();
        }
        return totalPay;
    }

    public float getRegularHours() {
        return hoursWorked <= 40.0f ? hoursWorked : 40.0f;
    }

    public float getOverTimeHours() {
        return hoursWorked <= 40.0f ? 0f : (hoursWorked - 40f);
    }
}