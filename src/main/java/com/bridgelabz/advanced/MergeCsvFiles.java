package com.bridgelabz.advanced;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCsvFiles {

    public static void main(String[] args) {
        String file1 = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\students.csv";
        String file2 = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\students1.csv";
        String outputFile = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\merged_students.csv";

        mergeCSVFiles(file1, file2, outputFile);
    }

    public static void mergeCSVFiles(String file1, String file2, String outputFile) {
        Map<String, String[]> studentDataMap = new HashMap<>();

        try (
                CSVReader reader1 = new CSVReader(new FileReader(file1));
                CSVReader reader2 = new CSVReader(new FileReader(file2));
                CSVWriter writer = new CSVWriter(new FileWriter(outputFile))
        ) {
            String[] header1 = reader1.readNext(); // ID, Name, Age
            String[] header2 = reader2.readNext(); // ID, Marks, Grade

            // Create merged header
            String[] mergedHeader = {"ID", "Name", "Age", "Email", "Marks", "Grade"};
            writer.writeNext(mergedHeader);

            // Read file1 and store ID -> [Name, Age]
            String[] line1;
            while ((line1 = reader1.readNext()) != null) {
                String id = line1[0];
                String name = line1[1];
                String age = line1[2];
                String email=line1[3];
                studentDataMap.put(id, new String[]{name, age, email});
            }

            // Read file2 and merge using ID
            String[] line2;
            while ((line2 = reader2.readNext()) != null) {
                String id = line2[0];
                String marks = line2[1];
                String grade = line2[2];

                if (studentDataMap.containsKey(id)) {
                    String[] data1 = studentDataMap.get(id);
                    String[] mergedRow = {id, data1[0], data1[1], data1[2], marks, grade};
                    writer.writeNext(mergedRow);
                }
            }

            System.out.println("Merged CSV created: " + outputFile);

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
