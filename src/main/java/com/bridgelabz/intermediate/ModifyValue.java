package com.bridgelabz.intermediate;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyValue {
    public static void main(String[] args) {
        getSalaryByCSV("C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediate\\employees.csv");
    }
    // Read the salary and increase it by 10%
    public static void getSalaryByCSV(String filePath){
            try(CSVReader reader=new CSVReader(new FileReader(filePath));
                CSVWriter writer=new CSVWriter(new FileWriter("C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediate\\updated_employees.csv"))
            ){
                String line[];
                String header[]=reader.readNext();
                writer.writeNext(header);
                while((line=reader.readNext())!=null) {
                    String department = line[2];
                    double salary = Double.parseDouble(line[3]);

                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.1;
                        line[3] = String.valueOf((int) salary); //Converts the int value into a String, so it can be placed into the nextLine array, which holds String values.
                    }
                    writer.writeNext(line);
                }
                System.out.println("Updated file saved as: " + "updated_employees.csv");

            } catch (IOException | CsvValidationException e) {
                e.printStackTrace();
            }
        }
        }





