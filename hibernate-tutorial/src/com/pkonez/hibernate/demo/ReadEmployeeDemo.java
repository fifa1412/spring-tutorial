package com.pkonez.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pkonez.hibernate.demo.entity.Employee;
import com.pkonez.hibernate.demo.entity.Student;

public class ReadEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			int employeeId = 1;
			
			// start a transaction
			session.beginTransaction();
			
			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			// display the employee object
			System.out.println("Employee: " + myEmployee);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
