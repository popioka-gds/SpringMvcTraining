package com.ey.spring.hibernate.demo;

import com.ey.spring.hibernate.demo.entity.Student;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class CreateStudentDemo {

    public static void main(String[] args) {


// create session factory
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
             // create session
             Session session = factory.getCurrentSession()) {


            // create a student object
            System.out.println("Creating new student object...");
            Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

            // start a transaction
            session.beginTransaction();

           /* NativeQuery nativeQuery = session.createNativeQuery("CREATE TABLE `student` (\n" +
                    "  `id` int NOT NULL PRIMARY KEY,\n" +
                    "  `first_name` varchar(45) DEFAULT NULL,\n" +
                    "  `last_name` varchar(45) DEFAULT NULL,\n" +
                    "  `email` varchar(45) DEFAULT NULL" +
                    ");");
            nativeQuery.executeUpdate();*/

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
    }

}





