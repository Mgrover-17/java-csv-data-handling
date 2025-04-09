package com.bridgelabz.advanced;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVdata {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\employees.csv";
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        // Email regex: must have text@text.text
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

        // Phone regex: must be exactly 10 digits
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read header
            String[] line;
            int lineNumber = 2; // Line 1 is header, so data starts from line 2

            while ((line = reader.readNext()) != null) {
                String email = line[4]; // assuming email is column index 4
                String phone = line[5]; // assuming phone is column index 5

                boolean valid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid Email at line " + lineNumber + ": " + email);
                    valid = false;
                }

                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid Phone at line " + lineNumber + ": " + phone);
                    valid = false;
                }

                if (!valid) {
                    System.out.println("Full Row: " + String.join(", ", line));
                    System.out.println("----------------------------------");
                }

                lineNumber++;
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
