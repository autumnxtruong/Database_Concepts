package Model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity	
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //an use JOIN to separate the tables according to difffereent attributes/columns
													// theres also a foreign key  annotation  june 29 1:10
@DiscriminatorColumn(name = "memberType") //will create another column that can be be valaued differently for any class who extends this class
										  //Cooresponding values will be annotated in child class @discriminatorValue
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	
	public Staff(String sname) {
		super();
		this.sname = sname;
	}
	public Staff() {
		super();
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
