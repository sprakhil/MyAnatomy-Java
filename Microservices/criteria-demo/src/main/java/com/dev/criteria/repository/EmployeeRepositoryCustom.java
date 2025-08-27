package com.dev.criteria.repository;

import java.util.List;

import com.dev.criteria.model.Employee;

public interface EmployeeRepositoryCustom {
	List<Employee> findEmployees(String department, Double minSalary);
}
