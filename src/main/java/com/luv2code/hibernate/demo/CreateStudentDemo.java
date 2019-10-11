package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {




		
		try (SessionFactory factory = new Configuration()
					 .configure("hibernate.cfg.xml")
					 .addAnnotatedClass(Student.class)
					 .buildSessionFactory();) {

			// create session
			Session session = factory.getCurrentSession();

			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Paul", "Does", "paul@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}





