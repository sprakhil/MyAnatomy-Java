package ses_2;

import java.util.Scanner;
import java.util.ArrayList;

class Employee {
    private String name;
    private int age;
    private String designation; 
    private double salary;

    public Employee(String name, int age, String designation, double salary) {
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }

    public void raiseSal() {
        switch (designation) {
            case "P":
                salary += 20;
                break;
            case "M":
                salary += 25;
                break;
            case "T":
                salary += 15;
                break;
            default:
                System.out.println("Unknown designation. No raise applied for " + name);
        }
    }

    public void display() {
        String fullDesig = designation.equals("P") ? "Programmer"
                          : designation.equals("M") ? "Manager"
                          : designation.equals("T") ? "Tester" : designation;
        System.out.printf("Name: %s, Age: %d, Designation: %s, Salary: %.2f\n", name, age, fullDesig, salary);
    }
}

public class EmployeeManager {
	private ArrayList<Employee> employees = new ArrayList<>();

    public void create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter designation (P/M/T): ");
        String designation = sc.nextLine().trim().toUpperCase();

        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        employees.add(new Employee(name, age, designation, salary));
        
        sc.close();
    }

    public void display() {
        if (employees.isEmpty()) {
            System.out.println("No employee data available.");
        } else {
            for (Employee emp : employees) {
                emp.display();
            }
        }
    }

    public void raiseSal() {
        for (Employee emp : employees) {
            emp.raiseSal();
        }
        System.out.println("Salaries updated as per designation.");
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions: 1.Create  2.Display  3.Raise Salary  4.Exit");
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: manager.create(); break;
                case 2: manager.display(); break;
                case 3: manager.raiseSal(); break;
                case 4: return;
                default: System.out.println("Invalid choice.");
            }
            sc.close();
        }
    }
}
