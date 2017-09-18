package com.tdn.Models;

import javax.validation.constraints.Pattern;


public class User {
	private int id;
	private String role;
	private String userName;
	@Pattern(regexp="^.*((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])).*$")
	private String password;
	private String confirmedPassword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	
	
	
	
	
}
