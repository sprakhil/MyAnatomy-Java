package com.example;

import java.util.List;

import org.hibernate.Session;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
//		session.persist(new Employee("AAAA", "IT", 50000, "Developer"));
//		session.persist(new Employee("BBBB", "HR", 60000, "Manger"));
//		session.persist(new Employee("CCCC", "IT", 70000, "Developer"));
//		session.persist(new Employee("DDDD", "Finance", 40000, "Analyst"));
		
		session.getTransaction().commit();
		
		List<Employee> result = EmployeeSearchService.searchEmployees(session, "IT", 70000.0, "Developer");
		
		System.out.println();
		System.out.println("----RESULT FROM CRITERIA QUERY----");
		
		for(Employee emp : result) {
			System.out.println(emp.getName()+" | "+emp.getDepartment()+" | "+emp.getDesignation()+" | "+emp.getSalary());
		}
		
		session.close();
		HibernateUtil.getSessionfactory().close();
	}
}
