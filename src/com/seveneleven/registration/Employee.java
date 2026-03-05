/* @author Developer
 * @version 5.0
 * Employee entry
 */

package com.seveneleven.registration;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;



public class Employee {
	private Validator validator;

	private String empId;
	private String name;
	private String email;
	
	private String phone;
	
	private UserAccount account;
	
	public Employee(String empId, String name, String email, String phone, UserAccount account, Validator validator) throws ValidationException {
		this.validator = validator;
		try {
			Validator.validateEmail(email);
			this.email= email;
			Validator.validateEmpId(empId);
			this.empId = empId;
			Validator.validatePhone(phone);
			this.phone = phone;
		}finally {
			
		}
		
		this.name = name;
		this.account = account;
		
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		String empId = this.empId;
		String name = this.name;
		UserAccount account = this.account;
		String email = this.email;
		String phone = this.phone;
		
		String formatted = "Name: " + name + "Emp ID : " + empId + "email : " + email + "phone number: " + phone;
		
		return formatted;
	
		

	}
	
	public void persist() throws IOException {
		String fileName = "EmployeeDetails.txt";
		
		String empId = this.empId;
		String name = this.name;
		UserAccount account = this.account;
		String email = this.email;
		String phone = this.phone;
		
		String content = "Name: " + name + "Emp ID : " + empId + "email : " + email + "phone number: " + phone;
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(content);
			writer.newLine();
			System.out.println("Data persisted in file : " + fileName);
			
		} catch(IOException e) {
			System.out.println("An error occured while writing ");
			
		}
		
	}
	
	public String getEmpId() {
	    return empId;
	}

	public String getName() {
	    return name;
	}
	
	
	
	
}
