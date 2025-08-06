package com.nativesql;

import java.util.List;

import org.hibernate.Session;

public class MainApp {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		
//		session.persist(new NativeSQLEmployee("John","IT",60000));
//		session.persist(new NativeSQLEmployee("Alice","HR",50000));
//		session.persist(new NativeSQLEmployee("Rob","IT",70000));
		
//		session.getTransaction().commit();
		
		System.out.println("\nEmployees from IT department:");
		String sql = "SELECT * FROM NativeSQLEmployee WHERE department = :dept";
		List<NativeSQLEmployee> itrEmployee = session.createNativeQuery(sql, NativeSQLEmployee.class)
				.setParameter("dept","IT")
				.getResultList();
		
		for(NativeSQLEmployee emp : itrEmployee) {
			System.out.println(emp.getName()+ " - "+emp.getDepartment());
		}
		
		session.close();
		HibernateUtil.getSessionfactory().close();
	}
}
