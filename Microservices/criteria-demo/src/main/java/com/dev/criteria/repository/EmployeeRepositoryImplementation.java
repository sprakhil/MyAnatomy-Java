package com.dev.criteria.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.criteria.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class EmployeeRepositoryImplementation implements EmployeeRepositoryCustom{
	
	private EntityManager entityManager;

	@Override
	public List<Employee> findEmployees(String department, Double minSalary) {
		// get a CriteriaBuilder
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		// create CriteriaQuery
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		
		// define root
		Root<Employee> root = cq.from(Employee.class);
		
		// adding condition dynamically
		List<Predicate> predicates = new ArrayList<>();
		
		if(department != null) {
			predicates.add(cb.equal(root.get("department"), department));
		}
		if(minSalary != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("salary"), minSalary));
		}
		
		//combine predicates
		cq.select(root).where(predicates.toArray(new Predicate[0]));
		
		//run query
		return entityManager.createQuery(cq).getResultList();
	}
	
	
}
