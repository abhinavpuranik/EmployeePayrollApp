//@author Developer
//version 3.0
//Password hashing utility class

package com.seveneleven.utility;

import java.security.MessageDigest;

public class PasswordUtil {

    public static String hash(String password) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (Exception e) {
            throw new RuntimeException("Hashing failed");
        }
    }
}