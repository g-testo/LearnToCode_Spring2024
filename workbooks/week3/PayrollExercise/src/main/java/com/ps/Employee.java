package com.ps;

public class Employee {
    private long employeeId;
    private String name;
    private float hoursWorked;
    private float payRate;

    public Employee(long employeeId, String name, float hoursWorked, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public float calcGrossPay(){
        return this.hoursWorked * this.payRate;
    }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return this.payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + this.name + '\'' +
                ", hoursWorked=" + this.hoursWorked +
                ", payRate=" + this.payRate +
                '}';
    }
}
