package com.bridgelabz.intermediate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String searchName=sc.nextLine().trim();
        try(CSVReader reader=new CSVReader(new FileReader("C:\\Users\\Manvi\\Desktop\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediate\\employees.csv"))){
            String line[];
            reader.readNext();

            while((line=reader.readNext())!=null){
                String name=line[1].trim();
                if(name.equalsIgnoreCase(searchName)){
                    String department=line[2].trim();
                    String salary=line[3].trim();

                    System.out.println("Employee Found:");
                    System.out.println("Name: " + name);
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    return;
                }
            }
            System.out.println("Employee with name "+searchName+" not found");
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}
