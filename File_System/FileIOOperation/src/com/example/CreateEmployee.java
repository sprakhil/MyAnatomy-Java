package com.example;
 
import java.io.FileWriter;
import java.io.IOException;
 
public class CreateEmployee {
public static void main(String[] args) throws IOException {
	FileWriter fw = new FileWriter("C:\\Users\\sprak\\eclipse-workspace\\MyAnatomy\\File_System\\FileIOOperation\\src\\com\\example\\employee.txt");
	fw.write("101,Rahul , HR\n");
	fw.write("102,Kishore , IT\n");
	fw.close();
	System.out.println("employee added.");
}
}
