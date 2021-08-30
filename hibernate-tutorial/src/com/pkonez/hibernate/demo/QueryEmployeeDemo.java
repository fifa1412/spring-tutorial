package com.pkonez.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pkonez.hibernate.demo.entity.Employee;
import com.pkonez.hibernate.demo.entity.Student;

public class QueryEmployeeDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query employee: company='3BB'
			List<Employee> theEmployee = session.createQuery("from Employee e where e.company='3BB'").getResultList();
			
			// display the employee list
			System.out.println("\n\nEmployee who have company of 3BB");
			System.out.println(theEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}

	}

}
