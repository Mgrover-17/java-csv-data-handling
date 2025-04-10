package com.bridgelabz.advanced;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String email;

    // Constructors, Getters, Setters
    public Student(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Student { id=" + id + ", name='" + name + "', age=" + age + ", email='" + email + "' }";
    }
}

public class ConvertJSONtoCSV {

    public static void main(String[] args) {
        String jsonInput = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\students.json";
        String csvOutput = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\students.csv";
        String jsonOutput = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\students_converted_back.json";

        convertJsonToCsv(jsonInput, csvOutput);
        convertCsvToJson(csvOutput, jsonOutput);
    }

    // Convert JSON → CSV
    public static void convertJsonToCsv(String jsonFile, String csvFile) {
        try (Reader reader = new FileReader(jsonFile);
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            Gson gson = new Gson();
            Type studentListType = new TypeToken<List<Student>>() {}.getType();
            List<Student> students = gson.fromJson(reader, studentListType);

            // Write CSV header
            String[] header = {"ID", "Name", "Age", "Email"};
            writer.writeNext(header);

            // Write each student
            for (Student s : students) {
                String[] row = {
                        String.valueOf(s.getId()),
                        s.getName(),
                        String.valueOf(s.getAge()),
                        s.getEmail()
                };
                writer.writeNext(row);
            }

            System.out.println("JSON converted to CSV: " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Convert CSV → JSON
    public static void convertCsvToJson(String csvFile, String jsonFile) {
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] line;
            reader.readNext(); // skip header

            while ((line = reader.readNext()) != null) {
                int id = Integer.parseInt(line[0]);
                String name = line[1];
                int age = Integer.parseInt(line[2]);
                String email = line[3];

                studentList.add(new Student(id, name, age, email));
            }

            Gson gson = new Gson();
            try (Writer writer = new FileWriter(jsonFile)) {
                gson.toJson(studentList, writer);
            }

            System.out.println("CSV converted back to JSON: " + jsonFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
