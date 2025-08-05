package com.management;

import org.hibernate.Session;
import java.util.List;

public class EmployeeService {
    private EmployeeDataAccess dataAccess = new EmployeeDataAccess();

    public void createEmployee(Session session, String name, int age, String designation) {
        Employee emp = new Employee(name, age, designation);
        dataAccess.saveEmployee(session, emp);
    }

    public List<Employee> fetchAllEmployees(Session session) {
        return dataAccess.getAllEmployees(session);
    }

    public void raiseSalary(Session session, int id, double percent) {
        dataAccess.raiseSalary(session, id, percent);
    }
    
    public void deleteEmployee(Session session, int employeeId) {
        dataAccess.deleteEmployee(session, employeeId);
    }
}
