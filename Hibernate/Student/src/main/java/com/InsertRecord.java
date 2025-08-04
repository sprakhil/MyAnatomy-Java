package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertRecord {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student st = new Student();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the id: ");
		int uid = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter the name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter the city: ");
		String city = sc.nextLine();
		
		System.out.print("Enter the pin: ");
		int pin = sc.nextInt();
		sc.nextLine();
		
		st.setUid(uid);
		st.setName(name);
		st.setCity(city);
		st.setPin(pin);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(st);
		
		tx.commit();
		
		sc.close();
	}
}
