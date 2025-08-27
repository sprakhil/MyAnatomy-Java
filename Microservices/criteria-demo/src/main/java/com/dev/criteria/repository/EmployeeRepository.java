package com.dev.criteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.criteria.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {
	
}
