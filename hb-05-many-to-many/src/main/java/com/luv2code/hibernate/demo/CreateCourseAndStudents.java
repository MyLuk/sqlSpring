package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudents {
    public static void main(String[] args) {




        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory() ;
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = new Course("How to be Russian in 60 min");
            session.save(course);
            Student student1 = new Student("Mikle", "Does", "paul@luv2code.com");
            Student student2 = new Student("Pikle", "Does", "paul@luv2code.com");
            course.addStudent(student1);
            course.addStudent(student2);
            session.save(student1);
            session.save(student2);
            System.out.println(course.getStudents());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
