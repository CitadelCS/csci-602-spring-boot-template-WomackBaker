package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class InheritanceDemo {
    public static void printEmployees(ArrayList<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new HourlyEmployee("John Doe", LocalDate.of(2009, 5, 21), 50.5, 160.0));
        employees.add(new HourlyEmployee("John Doe", LocalDate.of(2005, 9, 1), 150.5, 80.0));
        employees.add(new SalariedEmployee("Moe Howard", LocalDate.of(2004, 1, 1), 75000.0));
        employees.add(new SalariedEmployee("Curly Howard", LocalDate.of(2018, 1, 1), 105000.0));

        System.out.println("\nList of Employees (before sorting)");
        printEmployees(employees);

        Collections.sort(employees);
        System.out.println("\nList of Employees (after sorting)");
        printEmployees(employees);

        System.out.println("\nMonthly Pay");
        double totalPay = 0.0;
        for (Employee employee : employees) {
            System.out.printf("%s: $%,.2f\n", employee.getName(), employee.getMonthlyPay());
            totalPay += employee.getMonthlyPay();
        }
        System.out.printf("Total Monthly Pay: $%,.2f\n", totalPay);

    }
}