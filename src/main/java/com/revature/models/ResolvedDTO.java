package com.revature.models;

import java.sql.Timestamp;

public class ResolvedDTO {
	
	public String status;
	public int id;
	public Timestamp date;
	@Override
	public String toString() {
		return "ResolvedDTO [status=" + status + ", id=" + id + ", date=" + date + "]";
	}
	
}
