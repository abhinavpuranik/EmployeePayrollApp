//@author Developer
//version 2.0


package com.seveneleven.model;

import com.seveneleven.utility.PasswordUtil;

public class Manager extends User {

    public Manager(String username, String password) {
        super(username, password, "MANAGER");
    }

    public boolean authenticate(String username, String password) {

        String hashed = PasswordUtil.hash(password);

        return this.username.equals(username)
                && this.passwordHash.equals(hashed);
    }
}