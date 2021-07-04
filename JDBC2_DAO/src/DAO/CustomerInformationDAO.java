package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Customer_Entity;

public interface CustomerInformationDAO {
	//void FindCustomerByCountry() throws SQLException; //set as void bc unsure what rslt will be
	void FindcustomerByCCLimit(); //set as void bc unsure what rslt will be
	int updateCustomerInfo();
	int insertCustomerInfo();
	//ArrayList<Customer_Entity> FindCustomerByCountry() throws SQLException;
	ArrayList<Customer_Entity> FindCustomerByCountry(String countryName) throws SQLException;
}
