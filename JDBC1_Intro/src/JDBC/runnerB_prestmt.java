package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class runnerB_prestmt {

		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			// Java Database Connectivity API
			// manages connecting to a database, issuing queries and commands, and handling result sets 
			// obtained from the database.
			
			// Steps to uses JDBC
			// Register your database driver
			// Initialize your connection: database URL, username, password
			// Prepare  your statement **
			// Send your statement to the database
			// Get results from the database
			
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
			PreparedStatement prestmt = null;
			
			
			try {
				//Step 1 + ClassNotFoundException
				System.out.println("---------Step 1---------");
				System.out.println("Register Database Driver");
				System.out.println();
				Class.forName("org.mariadb.jdbc.Driver");
				//Step 2 + verify 
				System.out.println("---------Step 2---------");
				System.out.println("Initialize Connection");
				System.out.print("...");
				
				//final bc this should not be changed
				// localhost:3306 for LOCAL
				// for servers -> 125.36.44.454 (IP num (i think)) num:8080
				final String DRIVER_URL = "jdbc:mariadb://localhost:3306/classicmodels";
				//declare private so noone can access
				final String USER = "root";
				final String PASS = "Password";
				
				//Define Connection con as null globally
				//Connection con = DriverManager.getConnection(DRIVER_URL, USER, PASS);
				con = DriverManager.getConnection(DRIVER_URL, USER, PASS);
				System.out.println("Connection Successful!");
				System.out.println();
				
				//step 3 
				System.out.println("---------Step 3---------");
				System.out.println("PrepareStatement ");
				System.out.println();
				
				//Statement stmtt -> stmt bc declare at top
				//stmt = con.createStatement(); //createStatement() or prepareStatement() -> prepareStatement more professional
				String sql = "Select * from employees where employeeNumber = ?"; //this is a SQL query
				prestmt = con.prepareStatement(sql);
				prestmt.setInt(1,1002);
				
				
				
				
				//step 4 Extract data from db 
				//When you query the database you get a JDBC ResultSet back through 
				//which you can access the result of the query. Here is an example of executing a query against a database via JDBC:
				
				//declare rs at the stop
				//ResultSet rs = stmt.executeQuery(sql);
				rs = prestmt.executeQuery();
				System.out.println("---------Step 4---------");
				System.out.println("Extracted Data via ResultSet");
				
				//Step 5 show this data
				//grabbing db table column name
				ResultSetMetaData metadata = rs.getMetaData();
				String Col1 = metadata.getColumnName(1);
				String Col2 = metadata.getColumnName(2);
				String Col3 = metadata.getColumnName(3);
				String Col4 = metadata.getColumnName(4);
				
				System.out.println(Col1 + "|" + Col2 + "|" + Col3 + "|" + Col4);
				
				while(rs.next()) {
					//retrieve data
					int employeeNum = rs.getInt(1);
					String lastName = rs.getString(2);
					String firstName = rs.getString(3);
					String ext = rs.getString(4);
					System.out.println(employeeNum + " | " + lastName + " | " + firstName + " | " + ext);
					
				}
							
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace(); //use ClassNotFoundExceptionn bc if driver is deleted or changed
			}
	}

}
