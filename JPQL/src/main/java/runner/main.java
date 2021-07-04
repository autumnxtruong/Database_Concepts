package runner;

import Services.employeeServices;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		employeeServices es = new employeeServices();
//		es.findEmpFirstName();
		// es.findAllEmp();
		//es.findEmpByOfficeCode();
		es.findEmpByID();
		
		
	}

}
