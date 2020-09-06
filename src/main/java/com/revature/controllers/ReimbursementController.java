package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.IreimbursementDAO;
import com.revature.daos.reimbursementDAO;
import com.revature.models.Reimbursement;


public class ReimbursementController {
	
	IreimbursementDAO reimDAO = new reimbursementDAO();
	private static ObjectMapper om = new ObjectMapper();

	public void getReimbursement(HttpServletResponse res, int id) {
		// TODO Auto-generated method stub
		
	}

	public void getAllReimbursements(HttpServletResponse res) throws IOException{
		List<Reimbursement> all = reimDAO.viewAllTickets();
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);
		
	}

	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	public void updateReimbursement() {
		// TODO Auto-generated method stub
		
	}

}
