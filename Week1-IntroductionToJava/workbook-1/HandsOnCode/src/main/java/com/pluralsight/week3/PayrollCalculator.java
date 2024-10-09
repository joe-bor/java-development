package com.pluralsight.week3;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PayrollCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String fileName = promptFileName();
        String payrollFilename = promptPayrollFileName();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // this skips the first line. thanks Nima
            String input = bufferedReader.readLine();

            FileWriter fileWriter = new FileWriter(payrollFilename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id|name|gross pay\n");

            while((input = bufferedReader.readLine()) != null){
//                System.out.println(input);
                String[] arr = input.split(Pattern.quote("|"));
                int employeeId = Integer.parseInt(arr[0]);
                String employeeName = arr[1];
                double hoursWorked = Double.parseDouble(arr[2]);
                double payRate = Double.parseDouble(arr[3]);
                Employee employee = new Employee(employeeId, employeeName, hoursWorked, payRate);

                bufferedWriter.append(String.format("%d|%s|%f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
//                System.out.printf("Employee with id %d, name: %s, gross pay: %.2f \n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e){
            System.err.println(e);
        }

    } // end of main

    public static String promptFileName(){
        System.out.print("Enter the name of the file employee file to process: ");
        return scanner.nextLine();
    }

    public static String promptPayrollFileName(){
        System.out.print("Enter the name of the payroll file to create: ");
        return scanner.nextLine();
    }
}
