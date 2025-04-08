package com.bridgelabz.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrint {
    public static void main(String[] args) {
        try(BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Manvi\\Desktop\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basic\\students.csv"))){
            reader.readLine();
            String line;
            while((line=reader.readLine())!=null){
                String columns[]=line.split(",");
                System.out.println("ID: "+columns[0]+", Name: "+columns[1]+", Age: "+columns[2]+", Marks: "+columns[3]);

            }
        }
        catch(IOException e){
            System.out.println("exception"+e.getMessage());
        }
    }

}
