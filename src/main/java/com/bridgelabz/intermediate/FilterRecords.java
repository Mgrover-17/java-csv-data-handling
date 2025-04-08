package com.bridgelabz.intermediate;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        try(CSVReader reader=new CSVReader(new FileReader("C:\\Users\\Manvi\\Desktop\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\intermediate\\student_records.csv"))){
            String line[];
            reader.readNext();
            System.out.println("Students with Marks > 80:");
            while((line=reader.readNext())!=null){
                int marks=Integer.parseInt(line[3].trim());
                if(marks>80){
                    System.out.println("ID: "+line[0]+", Name: "+line[1]+", Age: "+line[2]+", Marks: "+line[3]);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
