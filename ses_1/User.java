package ses_1;

import java.util.Scanner;

public class User {
	public static void create() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name : ");
        String name = sc.nextLine();

    
        System.out.print("Do you want to enter your age (Y/N) : ");
        char ask = sc.next().charAt(0);
        sc.nextLine(); 

        if (ask == 'Y' || ask == 'y') {
            System.out.print("Enter your age : ");
            int age = sc.nextInt();
            display(name, age);
        } else if (ask == 'N' || ask == 'n') {
            display(name);
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
        }
        
        sc.close();
    }

    public static void display(String name) {
        System.out.println("Name : " + name);
    }

    public static void display(String name, int age) {
        System.out.println("Name : " + name + " Age : " + age);
    }

    public static void main(String[] args) {
        create();
    }
}
