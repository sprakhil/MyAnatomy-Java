package ses_4;

import java.util.Scanner;
import java.util.ArrayList;

@SuppressWarnings("serial")
class InvalidEmpNameException extends RuntimeException{
	public InvalidEmpNameException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class InvalidEmpAgeException extends RuntimeException{
	public InvalidEmpAgeException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class InvalidDesignationException extends RuntimeException{
	public InvalidDesignationException(String message) {
		super(message);
	}
}

class Employee {
	private String name;
	private int age;
	private String designation;
	private int salary;
	
	public Employee(String name, int age, String designation) {
		setName(name);
		setAge(age);
		setDesignation(designation);
		setSalary();
	}
	
	private void setName(String name) throws InvalidEmpNameException{
		if(!name.matches("[a-zA-Z]+")) {
			throw new InvalidEmpNameException("Name must contain only alphabets");
		}
		this.name = name;
	}
	
	private void setAge(int age) throws InvalidEmpAgeException{
		if(age < 18 || age > 65) {
			throw new InvalidEmpAgeException("Not Eligible to Work");
		}
		this.age = age;
	}
	
	private void setDesignation(String designation) throws InvalidDesignationException {
		designation = designation.trim().toLowerCase();
		switch(designation) {
			case "programmer" :
				this.designation = "Programmer";
				break;
			case "manager" :
				this.designation = "Manager";
				break;
			case "tester" :
				this.designation = "Tester";
				break;
			default:
				throw new InvalidDesignationException("Invalid Designation");
		}
	}
	
	private void setSalary() {
		switch(designation) {
			case "Programmer":
				this.salary = 25000;
				break;
			case "Manager" :
				this.salary = 20000;
				break;
			case "Tester" :
				this.salary = 15000;
				break;
		}
	}
	
	public String getName() {
        return name;
    }
	public void raiseSalary(double percent) {
		if(percent > 0) {
			salary += salary * percent / 100;
		}
	}
	
	public void display() {
		System.out.println("Name: " + name 
	            + ", Age: " + age 
	            + ", Designation: " + designation 
	            + ", Salary: " + salary);
	}
	
}

public class EmployeeManagement{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Employee> employees = new ArrayList<>();
	
	public static void create() {
		boolean entry = true;
		while(entry) {
			try {
				System.out.print("Enter Name : ");
				String name = sc.nextLine();
				
				System.out.print("Enter age : ");
				int age = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Designation(Programmer/Manager/Tester) : ");
				String designation = sc.nextLine();
				
				Employee emp = new Employee(name,age,designation);
				
				employees.add(emp);
				
				System.out.println("Successfully Created");
				
				System.out.print("Create another (Y/N) : ");
				String addMore = sc.nextLine();
				
				if(addMore.equalsIgnoreCase("n"))
					entry = false;
			} catch (InvalidEmpNameException | InvalidEmpAgeException | InvalidDesignationException e) {
                System.out.println("Input Error: " + e.getMessage());
                System.out.println("Please enter correct details\n");
            } catch (Exception e) {
                System.out.println("Invalid input type");
            }
		}
	}
	
	public static void display() {
		if(employees.isEmpty()) {
			System.out.println("No employee to display");
			return;
		}
		System.out.println("\nEmployee details : ");
		
		for(Employee emp : employees) {
			emp.display();
		}
	}
	
	private static void raiseSal() {
		if(employees.isEmpty()) {
			System.out.println("No employees exist");
			return;
		}
		
		System.out.println("Enter employee name : ");
		String name = sc.nextLine();
		
		Employee emp = null;
		for(Employee e : employees) {
			if(e.getName().equalsIgnoreCase(name)) {
				emp = e;
				break;
			}
		}
		
		if(emp == null) {
			System.out.println("Employee not found");
			return;
		}
		
		double percent = -1;
		
		do {
			System.out.print("Enter raise percent(+ve) : ");
			percent = sc.nextDouble();
			sc.nextLine();
		}while(percent <= 0);
		
		emp.raiseSalary(percent);
		System.out.println("Salary raised");
		emp.display();
	}
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("\nChoose an option:");
            System.out.println("1 - Create employee");
            System.out.println("2 - Display all employees");
            System.out.println("3 - Raise salary");
            System.out.println("4 - Exit");
            
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    raiseSal();
                    break;
                case 4:
                	System.out.println("Thank You!");
                	return;
                default :
                	System.out.println("Invalid option");
            }
		}
	}
}