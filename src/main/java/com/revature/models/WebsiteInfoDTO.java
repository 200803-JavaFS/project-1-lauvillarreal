package com.revature.models;

import java.sql.Timestamp;

public class WebsiteInfoDTO {
	public String type;
	public double amount;
	public Timestamp date;
	public String description;
	public String fname;
	public String lname;
	public String email;
	public String role;
	
	
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
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.role = role;
	}
	


	
}
