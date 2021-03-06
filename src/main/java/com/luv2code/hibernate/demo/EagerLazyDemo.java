package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {




        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory() ;
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);

            System.out.println("Instructor!!!!! " + instructor);
            System.out.println("Courses!!!!!! " + instructor.getCourses());

            session.getTransaction().commit();
            session.close();
            System.out.println("\nSession is closeig\n");
            System.out.println("Courses!!!!!! " + instructor.getCourses());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
