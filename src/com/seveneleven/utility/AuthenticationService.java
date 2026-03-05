
/* @author Developer
 * @version 3.0
 * 
 */
package com.seveneleven.utility;

import java.util.*;

import com.seveneleven.model.User;
import com.seveneleven.model.*;

public class AuthenticationService {

    private Map<String, User> users = new HashMap<>();
    private int maxAttempts = 3;

    public AuthenticationService() {

        users.put("emp1", new RegularEmployee("emp1", "Emp@1234"));
        users.put("manager1", new Manager("manager1", "Mng@1234"));
    }

    public Session login() {

        Scanner sc = new Scanner(System.in);

        int attempts = 0;

        while (attempts < maxAttempts) {

            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            User user = users.get(username);

            if (user != null && user.authenticate(username, password)) {

                System.out.println("Login successful!");

                Session session = new Session(username);

                showDashboard(user.getRole());

                return session;
            }

            attempts++;

            System.out.println("Login failed! Attempts left: "
                    + (maxAttempts - attempts));
        }

        System.out.println("Maximum login attempts exceeded!");
        return null;
    }

    private void showDashboard(String role) {

        System.out.println("\n--- DASHBOARD ---");

        if (role.equals("MANAGER")) {
            System.out.println("Manager Dashboard");
            System.out.println("Access: Reports, Employee Management");

        } else if (role.equals("EMPLOYEE")) {
            System.out.println("Employee Dashboard");
            System.out.println("Access: View Tasks, Submit Reports");
        }
    }
}