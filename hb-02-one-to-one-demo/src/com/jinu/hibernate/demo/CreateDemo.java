package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Instroctor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instroctor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			//create student 0bject
			Instroctor tempInstructor=new Instroctor("Sanju","dsa","sanju@gmail.com");
			InstructorDetails tempDetails=new InstructorDetails("http://fdasd/youtube","asdf df cosdfasde");
			tempInstructor.setInstructorDetails(tempDetails);
			
			//start Instructor
			//This will also save instructor details bcz of cascade type.all
			System.out.println("Saving Instructor and details details");
			session.beginTransaction();
			//save the student object
			session.save(tempInstructor);
		
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		finally{
			factory.close();
		}
		
		

	}

}
