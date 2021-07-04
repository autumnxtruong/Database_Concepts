package com.test.jpa.runner;

import com.test.jpa.services.CreatingEmployee;
import com.test.jpa.services.DeletingEmployee;
import com.test.jpa.services.FindingEmployee;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindingEmployee fe = new FindingEmployee();
		fe.findEmployee();
		
		CreatingEmployee ce  = new CreatingEmployee();
		ce.createEmployee();
		
		DeletingEmployee de = new DeletingEmployee();
		de.deleteEmployee();
		
		
		
	}
	

}
