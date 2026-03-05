/* @author Developer
 * @version 1.0
 * Entry point of UC1
 */



package com.seveneleven.registration;
import java.io.IOException;
import java.util.Scanner;
public class EmployeeRegistrationApp {

	public static void main(String[] args) throws ValidationException{
		Scanner sc = new Scanner(System.in);
		System.out.println("UC1: System Registration");
		
		try {
			System.out.println("Enter EMP ID: ");
			String empId = sc.nextLine();
			System.out.println("Enter Name: ");
			String name = sc.nextLine();
			System.out.println("Enter Email: ");
			String email = sc.nextLine();
			System.out.println("Enter Phone: ");
			String phone = sc.nextLine();
			System.out.println("Enter Username: ");
			String userName = sc.nextLine();
			System.out.println("Enter Password: ");
			String password = sc.nextLine();
			
			
			UserAccount userAccount = new UserAccount(userName, password);
			Validator validator = new Validator();
			
			Employee employee = new Employee(empId, name, email, phone, userAccount, validator);
			
			
			
			
			System.out.println(employee.toString());
			employee.persist();
			
			
		}catch(ValidationException e) {
			System.out.println("Validation failed: " + e.getMessage());
			
		}catch(IOException e) {
			System.out.println("Error saving employee data");
		}
	}
	
}
 