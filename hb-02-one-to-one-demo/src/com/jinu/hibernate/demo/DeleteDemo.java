package com.jinu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jinu.entity.Instroctor;
import com.jinu.entity.InstructorDetails;
import com.jinu.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instroctor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			
			int instid=1;
			//start Instructor
			session.beginTransaction();
			
			Instroctor instroctor=session.get(Instroctor.class, instid);
			session.delete(instroctor);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		finally{
			factory.close();
		}
		
		

	}

}
