package com.employee;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class EmployeeApp {

    public static void main(String[] args) {

        // Open Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT EMPLOYEES
        Employee e1 = new Employee(1, "Ram", 60000, "Developer");
        Employee e2 = new Employee(2, "Sita", 45000, "Tester");
        Employee e3 = new Employee(3, "Krishna", 75000, "Manager");

        session.save(e1);
        session.save(e2);
        session.save(e3);

        tx.commit();
        session.close();
        System.out.println("Employees inserted successfully!");

        // OPEN NEW SESSION FOR QUERIES
        session = HibernateUtil.getSessionFactory().openSession();

        // 1️⃣ EMPLOYEES WITH SALARY > 50,000
        Query<Employee> q1 =
                session.createQuery("FROM Employee WHERE salary > 50000", Employee.class);

        List<Employee> highSalary = q1.list();
        System.out.println("\nEmployees with salary > 50,000:");
        for (Employee e : highSalary) {
            System.out.println(e.getEmpName() + " - " + e.getSalary());
        }

        // 2️⃣ AVERAGE SALARY
        Query<Double> q2 =
                session.createQuery("SELECT AVG(salary) FROM Employee", Double.class);

        Double avgSalary = q2.uniqueResult();
        System.out.println("\nAverage Salary: " + avgSalary);

        session.close();
        System.out.println("\nProgram finished.");
    }
}
