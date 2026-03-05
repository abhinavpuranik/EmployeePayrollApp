
/* @author Developer
 * @version 4.0
 * 
 */
package com.seveneleven.model;

import com.seveneleven.utility.PasswordUtil;

public class RegularEmployee extends User {

    public RegularEmployee(String username, String password) {
        super(username, password, "EMPLOYEE");
    }

    public boolean authenticate(String username, String password) {
    	PasswordUtil passwordUtil = new PasswordUtil();
    	

        String hashed = passwordUtil.hash(password);

        return this.username.equals(username)
                && this.passwordHash.equals(hashed);
    }
}