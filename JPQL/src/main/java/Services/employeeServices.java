package Services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.EmployeeEntity;





public class employeeServices {
	EntityManagerFactory emfactory = null;
	 EntityManager em = null;
	 //declared as aglobal bc using it in every method so you dont have to instantiate these two again and again
	
	public void findEmpFirstName() {
		emfactory = Persistence.createEntityManagerFactory("JPQL");
		em = emfactory.createEntityManager();
		 
		 // ================= JPQL =========================
		Query findallemp =  em.createQuery("select e.firstName from EmployeeEntity e"); // use entity class name not the table name from the DB
		List<String> l = findallemp.getResultList();								//multple methods 1:36 June 29		
		
		
//		Query findallemp =  em.createQuery("select e.firstName,e.lastName from EmployeeEntity e"); 
//		List<Object[]> l = findallemp.getResultList();  //FOLLOW THE RULES FFOR getResultList select statement
		 
		//whe shoudl we use EmployeeEntity or Object[]?
		//
		for(String s: l) {
		System.out.println("Employee FirstName: " + s);
		
		}
		em.close();
		emfactory.close();
		
		
		
	}
	
	public void findAllEmp() {
		emfactory = Persistence.createEntityManagerFactory("JPQL");
		em = emfactory.createEntityManager();
		Query findallemp = em.createQuery("select e from EmployeeEntity e");
		
		List<EmployeeEntity> allempList = findallemp.getResultList();
		for(EmployeeEntity i: allempList) {
			System.out.println("Number: " + i.getEmployeeNumber());
			System.out.println("Email: " + i.getEmail());
			System.out.println("FirstName: " +i.getFirstName());
			System.out.println("LastName: " +i.getLastName());
			System.out.println("OfficeCode: " +i.getOfficeCode());
			
		}
		em.close();
		emfactory.close();
		 
	}
	
	public void findEmpByOfficeCode() {
		emfactory = Persistence.createEntityManagerFactory("JPQL");
		em = emfactory.createEntityManager();
		// Query findallemp = em.createQuery("select e from EmployeeEntity e where e.officeCode = 7"); //HARDCODE VALUE! HOW TO MAKE DYNAMIC
		Query findallemp = em.createQuery("select e from EmployeeEntity e where e.officeCode = ?1"); //reference to JDBC for formattting
																									//the only diffference is  how to label the fields
																									//?1 will coorespond to 1, ?2 will coorespond to 2, etc
																									// :PLACEONE -> "PLACEONE", :PLACE2 -> "PLACETWO"
		System.out.println("INPUT OFFICE_CODE:");
		Scanner sc = new Scanner(System.in);
		findallemp.setParameter(1, sc.nextInt());
		
		
		List<EmployeeEntity> allempList = findallemp.getResultList();
		for(EmployeeEntity i: allempList) {
			System.out.println("Number: " + i.getEmployeeNumber());
			System.out.println("Email: " + i.getEmail());
			System.out.println("FirstName: " +i.getFirstName());
			System.out.println("LastName: " +i.getLastName());
			System.out.println("OfficeCode: " +i.getOfficeCode());
			
		}
		em.close();
		emfactory.close();
		 
	}
	
	//==================================AGGREGATE FUNCTION
	
	public void findEmpByID() {
		emfactory = Persistence.createEntityManagerFactory("JPQL");
		em = emfactory.createEntityManager();
		
		Query findallemp = em.createQuery("select count(e) from EmployeeEntity e");  
																									
	
		long rslt = (long)findallemp.getSingleResult();
		System.out.println(rslt);
		em.close();
		emfactory.close();
		 
	}
}
