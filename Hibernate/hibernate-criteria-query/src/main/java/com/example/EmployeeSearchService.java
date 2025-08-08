package com.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;

public class EmployeeSearchService {
	public static List<Employee> searchEmployees(Session session, String department, Double minSalary, String designation) {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(department != null) {
			predicates.add(cb.equal(root.get("department"), department));
		}
		if(minSalary != null) {
			predicates.add(cb.equal(root.get("salary"), minSalary));
		}
		if(designation != null) {
			predicates.add(cb.equal(root.get("designation"), designation));
		}
		
		cq.select(root).where(cb.and(predicates.toArray(new Predicate[0])));
		return session.createQuery(cq).getResultList();
	}
}
