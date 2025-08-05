package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Student student = new Student();
		student.setName("Akhil");
		
		Address address = new Address();
		address.setCity("Jaipur");
		address.setState("Rajasthan");
		address.setPincode("342527");
		
		student.setAddress(address);
		
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		
		System.out.println("Student saved with Address!");
	}
}
