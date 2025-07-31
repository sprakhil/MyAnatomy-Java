package ses_3;

import java.util.Scanner;

class Detail{
    String name;
    int age;
    public Detail(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("Name : "+name+" Age : "+ age);
    }
}

public class ABC{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name : ");
        String name = sc.nextLine();
        System.out.print("Enter age : ");
        int age = sc.nextInt();

        Detail obj = new Detail(name, age);
        obj.display();
        
        sc.close();
    }
}
