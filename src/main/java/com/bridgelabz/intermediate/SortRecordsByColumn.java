package com.bridgelabz.intermediate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortRecordsByColumn {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediate\\employees.csv";
        sortAndPrintTopSalaries(filePath);
    }

    public static void sortAndPrintTopSalaries(String filePath) {
        List<String[]> employeeList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read header
            String[] line;

            while ((line = reader.readNext()) != null) {
                employeeList.add(line);
            }

            // Sort based on salary (index 3), descending
            employeeList.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[3]);
                double salaryB = Double.parseDouble(b[3]);
                return Double.compare(salaryB, salaryA); // Descending
            });

            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println(String.join(", ", header)); // Print header

            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                System.out.println(String.join(", ", employeeList.get(i)));
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
