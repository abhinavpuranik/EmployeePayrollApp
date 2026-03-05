/* @author Developer
 * @version 1.0
 * Entry point of UC1
 */

package com.seveneleven.registration;

import com.seveneleven.model.Payslip;
import com.seveneleven.model.Session;
import com.seveneleven.utility.*;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeRegistrationApp {

    public static void main(String[] args) throws ValidationException {

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

            AuthenticationService auth = new AuthenticationService();

            Session session = auth.login();

            if (session != null) {

                System.out.println(session);

                if (session.isExpired()) {
                    System.out.println("Session expired.");
                } else {
                    System.out.println("Session still valid.");
                }

                System.out.println("\n=== USE CASE 3: PAYSLIP GENERATION ===");

                System.out.println("Enter Month (e.g., January 2026): ");
                String month = sc.nextLine();

                System.out.println("Enter Basic Salary: ");
                double basic = sc.nextDouble();

                System.out.println("Enter HRA: ");
                double hra = sc.nextDouble();

                System.out.println("Enter DA: ");
                double da = sc.nextDouble();

                System.out.println("Enter Allowances: ");
                double allowances = sc.nextDouble();

                PayrollService payrollService = new PayrollService();

                Payslip payslip = payrollService.generatePayslip(
                        employee,
                        month,
                        basic,
                        hra,
                        da,
                        allowances
                );

                System.out.println(payslip);
                
                System.out.println("\n=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");

             // Clone
             Payslip cloned = (Payslip) payslip.clone();

             // Verify equality
             if (payslip.equals(cloned)) {
                 System.out.println("Verified: Download copy is equal to original.");
             }

             System.out.println("Original hashcode : " + payslip.hashCode());
             System.out.println("Cloned   hashcode : " + cloned.hashCode());

             try {

                 DownloadToken token = new DownloadToken();

                 if (token.isExpired()) {

                     System.out.println("Download token expired.");
                     return;
                 }

                 FileService fs = new FileService();

                 String textFile = fs.savePayslipAsText(cloned);

                 String pdfFile = fs.savePayslipAsPdf(cloned);

                 System.out.println("\nPayslip Download Successful.");

                 System.out.println("Saved as text file: " + textFile);

                 System.out.println("Saved as PDF file : " + pdfFile);

                 System.out.println("\nPrinted Payslip ...");

                 System.out.println(cloned);

             } catch (Exception e) {

                 System.out.println("Error during payslip download.");
             }
            }

        } catch (ValidationException e) {

            System.out.println("Validation failed: " + e.getMessage());

        } catch (IOException e) {

            System.out.println("Error saving employee data");

        }

    }

}