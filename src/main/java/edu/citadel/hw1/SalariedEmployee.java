package edu.citadel.hw1;

import java.time.LocalDate;

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(String name, LocalDate hireDate, double annualSalary) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee[name=" + getName() + ", hireDate=" + getHireDate() + ", annualSalary=" + annualSalary + "]";
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double getMonthlyPay() {
        return getAnnualSalary() / 12.0;
    }
}