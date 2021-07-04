package Model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue( value = "Teaching Staff")
public class TeachingStaff extends Staff { //if you extends Staff you get all of its attributes including annotations
	private String qualification;
	private String subjectexpertise;
	
	//==========================================================================================
	
	public TeachingStaff() {
		super();
	}
	

public TeachingStaff(String sname,String qualification, String subjectexpertise) {
		super(sname);
		this.qualification = qualification;
		this.subjectexpertise = subjectexpertise;
	}


	//	public TeachingStaff(int sid, String sname) {
//		super(sid, sname);
//		// TODO Auto-generated constructor stub
//	}
	//=========================================================================================
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getSubjectexpertise() {
		return subjectexpertise;
	}
	public void setSubjectexpertise(String subjectexpertise) {
		this.subjectexpertise = subjectexpertise;
	}
	
}
