package com.bridgelabz.advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadLargeFiles {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Manvi\\Desktop\\bridgelabz-workspace\\java-csv-data-handling\\src\\main\\java\\com\\bridgelabz\\advanced\\large_file.csv"; // replace with your file path
        processCSVInChunks(filePath, 100);
    }

    public static void processCSVInChunks(String filePath, int chunkSize) {
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // Read header
            System.out.println("Header: " + header);

            String line;
            ArrayList<String> chunk = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                chunk.add(line);

                if (chunk.size() == chunkSize) {
                    processChunk(chunk);
                    totalCount += chunk.size();
                    chunk.clear(); // Clear for next batch
                }
            }

            // Process remaining lines (less than chunkSize)
            if (!chunk.isEmpty()) {
                processChunk(chunk);
                totalCount += chunk.size();
            }

            System.out.println("Total records processed: " + totalCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processChunk(ArrayList<String> chunk) {
        // Simulate processing
        System.out.println("Processed chunk of size: " + chunk.size());
    }
}
