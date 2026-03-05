/* @author Developer
 * @version 6.0
 * Validates input
 */

package com.seveneleven.validation;

public class ValidationService {

    private static String sanitize(String input) {

        if(input == null) return "";

        return input.trim();
    }

    public static void validateEmail(String email)
            throws EmailValidationException {

        email = sanitize(email);

        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new EmailValidationException("Invalid Email Format.");
        }
    }

    public static void validatePhone(String phone)
            throws PhoneValidationException {

        phone = sanitize(phone);

        if(!phone.matches("\\d{10}")) {
            throw new PhoneValidationException(
                    "Phone number must contain exactly 10 digits.");
        }
    }

    public static void validatePassword(String password)
            throws PasswordValidationException {

        password = sanitize(password);

        if(password.length() < 6) {
            throw new PasswordValidationException(
                    "Password must be at least 6 characters long.");
        }

        if(!password.matches(".*[A-Z].*")) {
            throw new PasswordValidationException(
                    "Password must contain at least one uppercase letter.");
        }

        if(!password.matches(".*[a-z].*")) {
            throw new PasswordValidationException(
                    "Password must contain at least one lowercase letter.");
        }

        if(!password.matches(".*[0-9].*")) {
            throw new PasswordValidationException(
                    "Password must contain at least one number.");
        }
    }

    public static void validateEmployeeId(String empId)
            throws EmployeeIdValidationException {

        empId = sanitize(empId);

        if(!empId.matches("EMP-\\d{4}")) {
            throw new EmployeeIdValidationException(
                    "Employee ID must follow format EMP-XXXX.");
        }
    }
}