package Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "NonTeaching Staff")
 
public class NonTeachingStaff extends Staff {
	private String areaExpertise;
	
	//==========================================================================================
	public NonTeachingStaff() {
		super();
	}
	

	public NonTeachingStaff(String sname, String areaExpertise) {
		super(sname);
		this.areaExpertise = areaExpertise;
		
		// TODO Auto-generated constructor stub
	}






	//==========================================================================================
	public String getAreaExpertise() {
		return areaExpertise;
	}

	public void setAreaExpertise(String areaExpertise) {
		this.areaExpertise = areaExpertise;
	}
	

	
}
