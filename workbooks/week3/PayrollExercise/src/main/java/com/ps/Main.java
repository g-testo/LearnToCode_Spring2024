package com.ps;

import java.io.*;

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

                writeToFile("formattedEmployeeData.csv", String.format("%d,%s,%.2f\n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.calcGrossPay()
                ));

                System.out.printf("Printed: Employee ID: %d, Name: %s, Gross Pay: %.2f \n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.calcGrossPay()
                );
            }
            System.out.println("Printed to file successfully...");

            bufReader.close();
        } catch(Exception e){
            System.out.println("Error...");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String path, String str){
        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(path, true));
            bufWriter.write(str);
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}