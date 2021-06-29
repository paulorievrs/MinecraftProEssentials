package com.rievrs.proEssentials;

public class Users {
	public String name;
	public String email;
	public String[] roles;
	public boolean admin;
	
	public Users(String name, String email, String[] roles, boolean admin) {
		this.setName(name);
		this.setEmail(email);
		this.setRoles(roles);
		this.setAdmin(admin);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}

