package com.app.dto;

import java.util.Scanner;

import com.app.model.User;

public class InputRequest {
	static  Scanner sn=new Scanner(System.in);
 public static User register() {
	
	 System.out.println("Enter User Details:");
	 System.out.println("Enter user first name:");
	 String fname=sn.next();
	 System.out.println("Enter user last name:");
	 String lname=sn.next();
	 System.out.println("Enter user address:");
	 String address=sn.next();
	 System.out.println("Enter user mobile:");
	 long mob=sn.nextLong();
	 System.out.println("Enter user  name:");
	 String uname=sn.next();
	 System.out.println("Enter user password:");
	 String pass=sn.next();
	 System.out.println("Enter user role:");
	 String role=sn.next();
	return addUser(fname, lname, address, mob, uname, pass, role);
	 
 }
public static UserRequest login() {
	System.out.println("Enter user  name:");
	 String uname=sn.next();
	 System.out.println("Enter user password:");
	 String pass=sn.next();
	 System.out.println("Enter user role:");
	 String role=sn.next();
	 return new UserRequest(uname,pass,role);
 }


private static User addUser(String fname, String lname, String address, long mob, String uname, String pass,
		String role) {
	User user=new User();
	 user.setAddress(address);
	 user.setFisrtName(fname);
	 user.setLastName(lname);
	 user.setMobile(mob);
	 user.setPassword(pass);
	 user.setRole(role);
	 user.setUname(uname);
	 return user;
}
}