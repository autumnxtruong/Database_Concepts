package com.test.jpa.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.jpa.Model.EmployeeEntity;

public class FindingEmployee {

	public void findEmployee() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA1_TEKWEEK7");
		EntityManager em = emfactory.createEntityManager();
		
		EmployeeEntity foundemployee = em.find(EmployeeEntity.class, 1056);
		System.out.println("employee FIRST NAME = " + foundemployee.getFirstName());
	    System.out.println("employee LAST NAME = " + foundemployee.getLastName());
	    System.out.println("employee EMAIL = " + foundemployee.getEmail());
	    System.out.println("employee OfficeCode = " + foundemployee.getOfficeCode());

	    em.close();
	    emfactory.close();
	}
	
}
