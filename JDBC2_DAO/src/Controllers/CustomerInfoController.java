package Controllers;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CustomerInformationDAO;
import DAO.DbSQLConnection;
import Model.Customer_Entity;
import SQLQueries.SQLQueries;

public class CustomerInfoController extends DbSQLConnection implements CustomerInformationDAO {
	PreparedStatement prestmt = null;
	ResultSet rs = null;
	@Override
	public ArrayList<Customer_Entity> FindCustomerByCountry(String countryName) throws SQLException {
		// TODO Auto-generated method stub
		//BY EXTENDS DbSQLConnection you can directly call methtods
		Connection dbcon = connectDB();
		ArrayList<Customer_Entity> cs_List = new ArrayList<Customer_Entity>();
		//last modifcation at the very end. put queryr into queryclass
		//String query = "Select * from customers where country = ?";
		
		// preparestatement using dbcon
		//declare prestmt globally bc will be using in all methods
		//PreparedStatement prestmt -> prestmt 
		//prestmt = dbcon.prepareStatement(query);
		prestmt = dbcon.prepareStatement(SQLQueries.FINDCSBYCOUNTRY);
		prestmt.setString(1,countryName); //pass countryName as argument isntead of hardcoding tthe valule
		//execute query and grab data from db
		rs = prestmt.executeQuery();
		//need to display and its going to be multple row of data soooooo use while()
		while(rs.next()) {
//			//just to test first before using getters and setters
//			//System.out.println(name + dob + EmployeeId + email + country + status + creditLimit);
//			int customerID = rs.getInt(1);
//			String name = rs.getString(2);
//			String dob = rs.getString(3);
//			int EmployeeId = rs.getInt(4);
//			String email = rs.getString(5);
//			String country =rs.getString(6);
//			String status = rs.getString(7);
//			double creditLimit = rs.getDouble(8);
//			
//			System.out.println(name + dob + EmployeeId + email + country + status + creditLimit);
			
			//make more dynamic and professional by creating instance of fcustomere and using getters and setters
			Customer_Entity c = new Customer_Entity();
			c.setCustomerId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setDob(rs.getString(3));
			c.setCustomerId(rs.getInt(4));
			c.setEmail(rs.getString(5));
			c.setCountry(rs.getString(6));
			c.setStatus(rs.getString(7));
			c.setCreditLimit(rs.getDouble(8));
			//^^^^ Taking it a step furrther you can create a separate method to show the Customer Info
			//thats why you instantiate and declaarer an ArrayyListt of<Customer_Entity>
			
			cs_List.add(c);
		}
		return cs_List; // going to put everything into and arraylist instead of just hardcoding System.out.println();
		
	}
	
	//call this method in method above FindCustomerInfoByCuntry
	public void ShowCustomerInfoByCountry(String countryName) throws SQLException {
		//invoke method findcustomerbycountry // this method will retuurn you arrayList and the array list has object of the customerEntity which has the getters and setters
		ArrayList<Customer_Entity> customerList = FindCustomerByCountry(countryName);
		for(Customer_Entity c : customerList) {
			int CustomerID = c.getCustomerId();
			String Country = c.getCountry();
			Double ccLimit = c.getCreditLimit();
			String DOB = c.getDob();
			String email = c.getEmail();
			String name = c.getName();
			String status = c.getStatus();
			
			System.out.println(CustomerID + " | " + Country +" | " + ccLimit +" | " + DOB + " | " +email +" | " + name +" | " + status);
		}
				
	}
	

	@Override
	public void FindcustomerByCCLimit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateCustomerInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertCustomerInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
