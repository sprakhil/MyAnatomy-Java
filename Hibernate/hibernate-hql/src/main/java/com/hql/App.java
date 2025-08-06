package com.hql;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App {
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		MyEmployee e1 = new MyEmployee("Anand","HR", 25000);
//		MyEmployee e2 = new MyEmployee("Akhil","Finance", 40000);
//		MyEmployee e3 = new MyEmployee("Shiva","IT", 55000);
		
//		session.persist(e1);
//		session.persist(e2);
//		session.persist(e3);
		
		System.out.println("Fetching employee with salary > 30000 using HQL : ");
		Query<MyEmployee> query = session.createQuery("from MyEmployee where salary > 30000", MyEmployee.class);
		
		List<MyEmployee> employees = query.list();
		
		for(MyEmployee emp : employees) {
			System.out.println(emp);
		}
		tx.commit();
		session.close();
		factory.close();
	}
}
