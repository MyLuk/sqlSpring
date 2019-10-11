package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesToStudent {
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
            Student student = session.get(Student.class, 2);
            Course course = new Course("Java profi");
            Course course1 = new Course("Youga");
            System.out.println(student.getCourses());
            student.addCourse(course);
            student.addCourse(course1);
            session.save(course);
            session.save(course1);
            System.out.println(student.getCourses());
            System.out.println("Courses student "+course.getStudents());
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
