package com.dev.criteria.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.criteria.model.Employee;
import com.dev.criteria.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// add dummy employees
	@PostMapping("/add")
	private String addEmployees() {
		employeeRepository.saveAll(Arrays.asList(
				new Employee("Anand", "IT", 60000.0),
				new Employee("Vivek", "Talent Acquisition", 46000.0),
				new Employee("Chaitra", "Finance", 80000.0),
				new Employee("Akhilesh", "IT", 100000.0)
				));
		return "Employee added!";
	}
	
	public List<Employee> searchEmployee(
			@RequestParam(required = false) String department,
			@RequestParam(required = false) Double minSalary){
		return employeeRepository.findEmployees(department, minSalary);
	}
}
