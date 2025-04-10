package com.bridgelabz.advanced;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertDataToObjects {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediate\\students.csv";  // Path to your CSV file
        List<Student> students = readStudentsFromCSV(filePath);

        System.out.println("Student List:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Method to read CSV and convert to Student objects
    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            reader.readNext(); // skip header

            while ((line = reader.readNext()) != null) {
                int id = Integer.parseInt(line[0]);
                String name = line[1];
                int age = Integer.parseInt(line[2]);
                String email = line[3];

                Student student = new Student(id, name, age, email);
                studentList.add(student);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    static class Student {
        private int id;
        private String name;
        private int age;
        private String email;

        public Student(int id, String name, int age, String email) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Student {" +
                    "ID = " + id +
                    ", Name = '" + name + '\'' +
                    ", Age = " + age +
                    ", Email = '" + email + '\'' +
                    '}';
        }
    }
}