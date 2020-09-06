package com.revature.models;

import java.sql.Timestamp;

public class WebsiteInfoDTO {
	private String type;
	private double amount;
	private Timestamp date;
	private String description;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Timestamp getDate() {
		return date;
	}


	public void setDate(Timestamp date) {
		this.date = date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getFname() {
		return firstName;
	}


	public void setFname(String fname) {
		this.firstName = fname;
	}


	public String getLname() {
		return lastName;
	}


	public void setLname(String lname) {
		this.lastName = lname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public WebsiteInfoDTO() {
		super();
		
	}


	public WebsiteInfoDTO(String type, double amount, Timestamp date, String description, String fname, String lname,
			String email, String role) {
		super();
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.role = role;
	}
	


	
}
