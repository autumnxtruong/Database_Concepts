package Runner;

import java.sql.SQLException;
import java.util.Scanner;

import Controllers.CustomerInfoController;

public class runner_Customer {
	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1: Find Customer by Country");
		int input = sc.nextInt();
	
		
		CustomerInfoController cs = new CustomerInfoController();
		//cs.FindCustomerByCountry("USA"); //how to make more dynamic instead of hardcoding value USA?
										//SCANNER FOR USER INPUT
		
		if(input == 1) {
			System.out.println("Enter Country name: ");	
			String countryName = sc.next(); //nextLine() doesnt work....why???
			//cs.FindCustomerByCountry(countryName);
			//after modifying code to make more dynamic 
			cs.ShowCustomerInfoByCountry(countryName); //this method also invokes FindCustomerByCountry internally
			
		}
		
	}
}
