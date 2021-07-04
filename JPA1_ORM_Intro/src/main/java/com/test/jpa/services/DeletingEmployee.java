package com.test.jpa.services;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.jpa.Model.EmployeeEntity;

public class DeletingEmployee {
	
	public void deleteEmployee() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA1_TEKWEEK7");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Employee Number: ");
		EmployeeEntity delEmployee  = em.find(EmployeeEntity.class, sc.nextInt());
		em.remove(delEmployee);
		
		em.getTransaction().commit();
		em.close();
		emfactory.close();
	
		
		
	}
	
}
