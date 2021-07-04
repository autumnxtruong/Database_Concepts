package com.test.jpa.services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.jpa.Model.EmployeeEntity;


public class CreatingEmployee {
	public void createEmployee() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA1_TEKWEEK7");
		EntityManager em = emfactory.createEntityManager(); 
		em.getTransaction().begin();
		
		EmployeeEntity employee = new EmployeeEntity();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name:");
		employee.setFirstName(sc.next());
		System.out.println("Enter Last Name:");
		employee.setLastName(sc.next());
		System.out.println("Enter email:");
		employee.setEmail(sc.next());
		System.out.println("Enter OfficeCode:");
		employee.setOfficeCode(sc.nextInt());
		System.out.println("Enter Job Title:");
		employee.setJobTitle(sc.next());
		
		
		
//		employee.setLastName(sc.next());
//		employee.setEmail(sc.next());
//		employee.setOfficeCode(sc.next());
//		employee.setJobTitle(sc.next();
		
		
		
		
		
		
//		employee.setEmail("demoo@email.com");
//		employee.setFirstName("demoName");
//		employee.setLastName("demoLastName");
//		//employee.setEmployeeNumber(101); //need to make this dynqmic ATUO INCREMENT
//		employee.setOfficeCode(1);

		em.persist(employee);
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	}
	

	
	
}
