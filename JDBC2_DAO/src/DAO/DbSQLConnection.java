package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSQLConnection {
	Connection con = null;
	public Connection connectDB() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			final String DRIVER_URL = "jdbc:mariadb://localhost:3306/demodb";
			final String USER = "root";
			final String PASS = "Password";
			con = DriverManager.getConnection(DRIVER_URL, USER, PASS);
			 
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR: CAN'T CONNECT TO THE DB!!");
		}
		return con; //whats the purrpose of this method... to get a connection...thereffore return con
	}
	
	public void disconnectDB() {
		if(con != null) {
			try {
				con.close();
			}
			
			catch(SQLException e ) {
				e.printStackTrace();
			}
		}
	}
	
}
