package Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.NonTeachingStaff;
import Model.Staff;
import Model.TeachingStaff;

public class createStaff {
	 public void createStaffMember() {
		 EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA2_AdvancedMapping");
		 EntityManager em = emfactory.createEntityManager();
		 
			em.getTransaction().begin();
			
//			//testing Staff
			Staff sf = new Staff();
			//dont need to set ID bc its autoincremented
			sf.setSname("Autumn");
			
			//testing Teaching

			//TeachingStaff ts2 = new TeachingStaff("Autumn_Hardcode", "MBA", "Programmer");
			
			NonTeachingStaff ns = new NonTeachingStaff();
			ns.setSname("Autumn_NonTeaching_TestAuto");
			
		
			
			//store entity into db
			em.persist(sf);
			//em.persist(ts2);
			em.persist(ns);
			em.getTransaction().commit();
			em.close();
			
			emfactory.close();
			
	 }
}
