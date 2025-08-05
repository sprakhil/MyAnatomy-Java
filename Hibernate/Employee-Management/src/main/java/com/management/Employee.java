package com.management;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee-Records")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String designation;
    private int salary;

    public Employee() {}  

    public Employee(String name, int age, String designation) {
        setName(name);
        setAge(age);
        setDesignation(designation);
        setInitialSalary();
    }

    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) {
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name must contain only alphabets");
        }
        this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 18 || age > 65) {
            throw new IllegalArgumentException("Age must be between 18 and 65");
        }
        this.age = age;
    }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) {
        designation = designation.trim().toLowerCase();
        switch (designation) {
            case "programmer":
            case "manager":
            case "tester":
                this.designation = designation.substring(0, 1).toUpperCase() + designation.substring(1);
                break;
            default:
                throw new IllegalArgumentException("Invalid designation");
        }
    }

    public int getSalary() { return salary; }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setInitialSalary() {
        switch (designation) {
            case "Programmer":
                salary = 20000;
                break;
            case "Manager":
                salary = 25000;
                break;
            case "Tester":
                salary = 15000;
                break;
        }
    }
}
