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
            // Reader
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Writer
            FileWriter fileWriter = new FileWriter(payrollFilename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Skip reading the first line
            String input = bufferedReader.readLine();

            // Validate desired output format
            boolean isJsonWanted = false;
            if (payrollFilename.split(Pattern.quote("."))[1].equals("json")) {
                isJsonWanted = true;
            }

            if (isJsonWanted) {
                bufferedWriter.write("["); // for json format
            } else {
                bufferedWriter.write("id|name|gross pay\n");
            }

            while ((input = bufferedReader.readLine()) != null) {
//                System.out.println(input);
                String[] arr = input.split(Pattern.quote("|"));
                int employeeId = Integer.parseInt(arr[0]);
                String employeeName = arr[1];
                double hoursWorked = Double.parseDouble(arr[2]);
                double payRate = Double.parseDouble(arr[3]);
                Employee employee = new Employee(employeeId, employeeName, hoursWorked, payRate);

                if (isJsonWanted) {
                    //BONUS: write in json format
                    bufferedWriter.append(String.format("\n\t{\"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f},", employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
                } else {
                    bufferedWriter.append(String.format("%d|%s|%.2f\n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay()));
                }
//                System.out.printf("Employee with id %d, name: %s, gross pay: %.2f \n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }
            bufferedWriter.append("\n]");

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    } // end of main

    public static String promptFileName() {
        System.out.print("Enter the name of the file employee file to process: ");
        return scanner.nextLine();
    }

    public static String promptPayrollFileName() {
        System.out.print("Enter the name of the payroll file to create: ");
        return scanner.nextLine();
    }
}
