package com.eagerfetching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		Department dept = new Department("Developer");
		session.persist(dept);
		
		Employee e1 = new Employee("Akhil", dept);
		Employee e2 = new Employee("Akhilesh", dept);
		Employee e3 = new Employee("Navin", dept);
		
		session.persist(e1);
		session.persist(e2);
		session.persist(e3);
		
		session.getTransaction().commit();
		session.close();
		
		Session newSession = factory.openSession();
		Department saveDept = newSession.get(Department.class, dept.getId());
		
		System.out.println("\nDepartment Name: "+ saveDept.getName());
		
		System.out.println("\n---Printing Employees already fetched dur to EAGER---");
		saveDept.getEmployee().forEach(emp -> System.out.println(emp.getName()));
		
		newSession.close();
		factory.close();
	}
}
