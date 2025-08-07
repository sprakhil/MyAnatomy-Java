package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DeleteEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID to Delete: ");
        String targetID = sc.nextLine();

        File inputFile = new File("C:\\Users\\sprak\\eclipse-workspace\\MyAnatomy\\File_System\\FileIOOperation\\src\\com\\example\\employee.txt");
        File tempFile = new File("C:\\Users\\sprak\\eclipse-workspace\\MyAnatomy\\File_System\\FileIOOperation\\src\\com\\example\\temp.txt");

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].trim().equals(targetID.trim())) {
                    found = true;
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
            e.printStackTrace();
            return;
        } finally {
            sc.close();
        }

        if (found) {
            if (inputFile.delete()) {
                if (tempFile.renameTo(inputFile)) {
                    System.out.println("Employee deleted successfully.");
                } else {
                    System.out.println("Could not rename temp file.");
                }
            } else {
                System.out.println("Could not delete original file.");
            }
        } else {
            tempFile.delete();
            System.out.println("Employee ID not found.");
        }
    }
}
