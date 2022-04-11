package com.bridgelabz.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService{
        CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }

    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(){}

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList ){
        this.employeePayrollList = employeePayrollList;
    }

    private void readEPData(Scanner consoleIn){
        System.out.println("Enter Employee ID: ");
        int id = consoleIn.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = consoleIn.next();
        System.out.println("Enter Employee Salary: ");
        double salary = consoleIn.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    private void writeEPData(){
        System.out.println("\n Writing EP data to console: " + employeePayrollList);
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleIn = new Scanner(System.in);
        employeePayrollService.readEPData(consoleIn);
        employeePayrollService.writeEPData();
    }
}
