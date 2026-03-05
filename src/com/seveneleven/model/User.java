//@author Developer
//version 2.0
//Abstract User model

package com.seveneleven.model;

import com.seveneleven.utility.PasswordUtil;

public abstract class User {

		protected String username;
		protected String passwordHash;
		protected String role;
		
		public User(String username, String password, String role) {
			this.username = username;
		    this.passwordHash = PasswordUtil.hash(password);
		    this.role = role;

			
		}
		
		public abstract boolean authenticate(String username, String password);
		
		public String getRole() {
			return role;
		}
		
		
}
