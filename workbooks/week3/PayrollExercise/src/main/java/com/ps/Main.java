package com.ps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("employeeData.txt"));

            String line;
            while((line = bufReader.readLine()) != null){
                String[] splitLine = line.split("\\|");

                long id = Long.parseLong(splitLine[0]);
                String name = splitLine[1];
                float hoursWorked = Float.parseFloat(splitLine[2]);
                float payRate = Float.parseFloat(splitLine[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);

                System.out.printf("Employee ID: %d, Name: %s, Gross Pay: %.2f \n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.calcGrossPay()
                );
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}