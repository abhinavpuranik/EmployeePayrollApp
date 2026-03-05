/* @author Developer
 * @version 1.0
 * User login details
 */

package com.seveneleven.registration;

public class UserAccount {
	
	private String userName;
	private String password;
	
	public UserAccount(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
