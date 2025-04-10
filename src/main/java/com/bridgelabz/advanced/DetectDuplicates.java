package com.bridgelabz.advanced;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\students.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<String> seenIds = new HashSet<>();
        List<String[]> duplicateRows = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read header
            String[] line;

            while ((line = reader.readNext()) != null) {
                String id = line[0]; // assuming ID is in column 0

                if (seenIds.contains(id)) {
                    duplicateRows.add(line);
                } else {
                    seenIds.add(id);
                }
            }

            // Print duplicate rows
            if (duplicateRows.isEmpty()) {
                System.out.println("No duplicate IDs found.");
            } else {
                System.out.println("Duplicate Records Found:");
                System.out.println(String.join(", ", header)); // print header
                for (String[] row : duplicateRows) {
                    System.out.println(String.join(", ", row));
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
