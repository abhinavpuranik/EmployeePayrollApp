package com.seveneleven.registration;
import com.seveneleven.model.Session;
import com.seveneleven.utility.*;


public class UseCase2LoginApp {

    public static void main(String[] args) {

        System.out.println("=== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");

        AuthenticationService auth = new AuthenticationService();

        Session session = auth.login();

        if (session != null) {

            System.out.println(session);

            if (session.isExpired()) {
                System.out.println("Session expired.");
            } else {
                System.out.println("Session still valid.");
            }
        }
    }
}