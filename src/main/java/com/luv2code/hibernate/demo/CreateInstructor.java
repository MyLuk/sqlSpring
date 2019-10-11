package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructor {

    public static void main(String[] args) {


        Instructor instructor = new Instructor("Micha", "Lukov", "luk@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("testchannel", "mma");

        instructor.setInstructorDetail(instructorDetail);

        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        }


    }

}
