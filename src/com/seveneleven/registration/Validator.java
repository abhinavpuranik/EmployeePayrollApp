/* @author Developer
 * @version 1.0
 * Class for checking input correctness
 */


package com.seveneleven.registration;

public class Validator {
	
	public static void validateEmail(String email) throws ValidationException{
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	    if (email == null || !email.matches(regex)) {
	        throw new ValidationException("Invalid email format");
	    }
	}
	
	public static void validatePhone(String phone) throws ValidationException{
		
		 String regex = "^[6-9][0-9]{9}$";

		 if (phone == null || !phone.matches(regex)) {
		        throw new ValidationException("Invalid Indian phone number");
		    }
	}
	
	public static void validateEmpId(String empId) throws ValidationException{
		
		 String regex = "^EMP-[0-9]{4}$";

		 if (empId == null || !empId.matches(regex)) {
		        throw new ValidationException("Invalid Employee ID format. Expected EMP-XXXX");
		    }
		
	}

}
