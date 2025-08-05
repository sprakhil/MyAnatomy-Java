package com.management;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EmployeeDataAccess {
    public void saveEmployee(Session session, Employee employee) {
        Transaction tx = session.beginTransaction();
        session.persist(employee);
        tx.commit();
    }

    public List<Employee> getAllEmployees(Session session) {
        return session.createQuery("from Employee", Employee.class).list();
    }

    public void raiseSalary(Session session, int employeeId, double percent) {
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, employeeId);
        if (emp != null) {
            int currentSalary = emp.getSalary();
            int raisedSalary = (int) (currentSalary + currentSalary * percent / 100);
            emp.setSalary(raisedSalary);
            session.update(emp);
        }
        tx.commit();
    }
    
    public void deleteEmployee(Session session, int employeeId) {
        Transaction tx = session.beginTransaction();
        Employee emp = session.get(Employee.class, employeeId);
        if (emp != null) {
            session.delete(emp);
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
        tx.commit();
    }

}
