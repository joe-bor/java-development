package com.pluralsight.week3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class PayrollCalculator {

    public static void main(String[] args) throws IOException {

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // this skips the first line. thanks Nima
            String input = bufferedReader.readLine();

            while((input = bufferedReader.readLine()) != null){
//                System.out.println(input);
                String[] arr = input.split(Pattern.quote("|"));
                int employeeId = Integer.parseInt(arr[0]);
                String employeeName = arr[1];
                double hoursWorked = Double.parseDouble(arr[2]);
                double payRate = Double.parseDouble(arr[3]);
                Employee employee = new Employee(employeeId, employeeName, hoursWorked, payRate);

                System.out.printf("Employee with id %d, name: %s, gross pay: %.2f \n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay());

            }

            bufferedReader.close();
        } catch (IOException e){
            System.err.println(e);
        }

    } // end of main
}
