package edu.citadel.hw1;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(String name, LocalDate hireDate, double wageRate, double hoursWorked) {
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee[name=" + getName() + ", hireDate=" + getHireDate() + ", wageRate=" + wageRate + ", hoursWorked=" + hoursWorked + "]";
    }

    public double getWageRate() {
        return wageRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getMonthlyPay() {
        return getHoursWorked() * getWageRate();
    }
}