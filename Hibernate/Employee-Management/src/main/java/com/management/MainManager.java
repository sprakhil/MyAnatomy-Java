package com.management;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class MainManager {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1 - Create employee");
                System.out.println("2 - Display all employees");
                System.out.println("3 - Raise salary");
                System.out.println("4 - Delete employee");
                System.out.println("5 - Exit");


                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                   	case 1:
                        try {
                            System.out.print("Enter employee name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter employee age: ");
                            int age = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter employee designation (Programmer/Manager/Tester): ");
                            String designation = sc.nextLine();

                            service.createEmployee(session, name, age, designation);
                            System.out.println("Employee created successfully.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                   	case 2:
                        List<Employee> employees = service.fetchAllEmployees(session);
                        if (employees.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {
                            System.out.println("ID | Name | Age | Designation | Salary");
                            System.out.println("---------------------------------------");
                            for (Employee emp : employees) {
                                System.out.printf("%d | %s | %d | %s | %d%n",
                                        emp.getId(), emp.getName(), emp.getAge(),
                                        emp.getDesignation(), emp.getSalary());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter employee ID to raise salary: ");
                        int id = sc.nextInt();

                        System.out.print("Enter percentage raise: ");
                        double percent = sc.nextDouble();

                        service.raiseSalary(session, id, percent);
                        System.out.println("Salary updated successfully.");
                        break;

                    case 4:
                        System.out.print("Enter employee ID to delete: ");
	                    int deleteId = sc.nextInt();
	                    sc.nextLine();
	                    service.deleteEmployee(session, deleteId);
	                    System.out.println("Employee deleted if existed.");
	                    break;

	                case 5:
	                    System.out.println("Thank you for using the application!");
	                    return;

                    default:
                        System.out.println("Invalid option, try again.");
                }
            }
        } finally {
            session.close();
            factory.close();
            sc.close();
        }
    }
}
