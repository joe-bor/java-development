package com.pluralsight.week5;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchInTime;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
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

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        double overtimeHours = getOverTimeHours();
        double totalPay = 0f;

        if (overtimeHours > 0f) {
            totalPay = (payRate * 1.5f * overtimeHours) + (payRate * getRegularHours());
        } else {
            totalPay = payRate * getRegularHours();
        }
        return totalPay;
    }

    public double getRegularHours() {
        return hoursWorked <= 40.0f ? hoursWorked : 40.0f;
    }

    public double getOverTimeHours() {
        return hoursWorked <= 40.0f ? 0f : (hoursWorked - 40f);
    }

    public double getPunchInTime() {
        return punchInTime;
    }

    public void setPunchInTime(double punchInTime) {
        this.punchInTime = punchInTime;
    }

    public void punchIn(double time) {
        setPunchInTime(time);
    }

    public void punchIn() {
        LocalTime currentTime =  LocalDateTime.now().toLocalTime();
        setPunchInTime(currentTime.getHour() +  (double) currentTime.getMinute() /60);
    }

    public void punchOut(double time) {
        setHoursWorked(this.getHoursWorked() + (time - getPunchInTime()));
        setPunchInTime(0); // turns out 0 in military time is also midnight
    }

    public void punchOut(){
        LocalTime currentTime = LocalDateTime.now().toLocalTime();
        double hoursWorked =  this.getPunchInTime() - (currentTime.getHour() + (double) currentTime.getMinute()/60);
        setHoursWorked(this.getHoursWorked() + hoursWorked);
    }

    public void punchTimeCard(double punchIn, double punchOut) {
        this.setHoursWorked(this.getHoursWorked() + punchOut - punchIn);
    }
}