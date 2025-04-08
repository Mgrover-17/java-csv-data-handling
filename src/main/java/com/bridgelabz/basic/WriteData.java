package com.bridgelabz.basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
    public static void main(String[] args) {
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Manvi\\Desktop\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basic\\employees.csv"))){
            writer.write("ID, Name, Department, Salary\n");
            writer.write("101, hiya, CSE, 50000\n");
            writer.write("102, Piya, Architecture, 20000");
            System.out.println("csv file created successfully");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
