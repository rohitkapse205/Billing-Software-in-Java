package com.app.dto;

public class UserRequest {
private String uname;
private String password;
private String role;
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "UserRequest [uname=" + uname + ", password=" + password + ", role=" + role + "]";
}
public UserRequest(String uname, String password, String role) {
	super();
	this.uname = uname;
	this.password = password;
	this.role = role;
}
public UserRequest() {
	super();
	// TODO Auto-generated constructor stub
}

}
