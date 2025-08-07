package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadEmployee {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sprak\\eclipse-workspace\\MyAnatomy\\File_System\\FileIOOperation\\src\\com\\example\\employee.txt"));
		String line;
		
		System.out.println("Employee Details: ");
		while((line = br.readLine()) != null) {
			String[] parts = line.split(",");
			System.out.println("ID: "+parts[0]+", Name: "+parts[1]+", Department: "+parts[2]);
		}
		br.close();
	}
}
