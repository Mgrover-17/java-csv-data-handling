package com.bridgelabz.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCount {
    public static void main(String[] args) {
        int count=0;
        try(BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Manvi\\Desktop\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\basic\\records.csv"))){
            reader.readLine();
            String line;
            while((line= reader.readLine())!=null){
                count++;
            }
            System.out.println("number of records excluding header is: "+count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
