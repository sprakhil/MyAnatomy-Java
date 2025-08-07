package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateEmployee {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID to Update: ");
		String targetID = sc.nextLine();
		
		System.out.println("Enter new name: ");
		String newName = sc.nextLine();
		
		System.out.println("Enter new department: ");
		String newDept = sc.nextLine();
		
		File inputFile = new File("C:\\Users\\sprak\\eclipse-workspace\\MyAnatomy\\File_System\\FileIOOperation\\src\\com\\example\\employee.txt");
		File tempFile = new File("C:\\Users\\sprak\\eclipse-workspace\\MyAnatomy\\File_System\\FileIOOperation\\src\\com\\example\\temp.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		String line;
		boolean found = false;
		
		while ((line = reader.readLine()) != null) {
		    String[] parts = line.split(",");
		    if (parts[0].trim().equals(targetID)) {
		        writer.write(targetID + ", " + newName + ", " + newDept + "\n");
		        found = true;
		    } else {
		        writer.write(line + "\n");
		    }
		}

		
		writer.close();
		reader.close();
		sc.close();
		
		inputFile.delete();
		tempFile.renameTo(inputFile);
		
		if(found) System.out.println("Employee updated sucessfully.");
		else System.out.println("Employee not found.");
	}
}
