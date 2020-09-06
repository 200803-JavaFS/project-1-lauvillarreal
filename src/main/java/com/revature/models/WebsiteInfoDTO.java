package com.revature.models;

import java.sql.Timestamp;

public class WebsiteInfoDTO extends LoginDTO{
	
	public String type;
	public double amount;
	public Timestamp date;
	public String description;
	public String firstName;
	public String lastName;
	public String email;
	public String role;
	public String username;
	public String password;
	
	



	public WebsiteInfoDTO() {
		super();
	}
	public WebsiteInfoDTO(String type, double amount, Timestamp date, String description) {
		super();
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.description = description;
		
	}





}
