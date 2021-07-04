package Model;


public class Customer_Entity {
	//check database for columns and column names -> these will be your variables
	private int CustomerId;
	private String name;
	private String dob;
	private String EmployeeId;
	private String email;
	private String country;
	private String status;
	private double creditLimit;
	public Customer_Entity(int customerId, String name, String dob, String employeeId, String email, String country,
			String status, double creditLimit) {
		super();
		CustomerId = customerId;
		this.name = name;
		this.dob = dob;
		EmployeeId = employeeId;
		this.email = email;
		this.country = country;
		this.status = status;
		this.creditLimit = creditLimit;
	}
	public Customer_Entity() {
		super();
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	
}
