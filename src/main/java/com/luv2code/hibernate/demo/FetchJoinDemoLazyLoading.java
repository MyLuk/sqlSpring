package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemoLazyLoading {
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

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                                                                + "JOIN FETCH i.courses "
                                                                + "where i.id=:theInstructorId",
                                                                Instructor.class);
            query.setParameter("theInstructorId", 1);
            Instructor tempInstructor = query.getSingleResult();
            System.out.println("Instructor!!!!! " + tempInstructor);
            session.getTransaction().commit();
            session.close();
            System.out.println("\nSession is closeig\n");
            System.out.println("Courses!!!!!! " + tempInstructor.getCourses());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
