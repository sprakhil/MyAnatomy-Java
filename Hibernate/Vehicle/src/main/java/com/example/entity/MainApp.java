package com.example.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		Car car = new Car();
		car.setBrand("Khatara");
		car.setNumberOfDoors(5);
		session.persist(car);
		
		Bike bike = new Bike();
		bike.setBrand("luna");
		bike.setHasCarrier(true);
		session.persist(bike);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
		
		System.out.println("Record Saved!");
	}
}
