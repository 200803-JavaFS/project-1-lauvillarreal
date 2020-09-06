package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.IreimbursementDAO;
import com.revature.daos.reimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.models.WebsiteInfoDTO;
import com.revature.services.ReimbursementService;


public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();
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

	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		System.out.println(body);
		
		WebsiteInfoDTO info = om.readValue(body, WebsiteInfoDTO.class);
		
		System.out.println(info);
		
		if (rs.addWebsiteInfo(info)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement was created!");
		} else {
			res.setStatus(403);
		}
		
	}
	

	public void updateReimbursement() {
		// TODO Auto-generated method stub
		
	}

}
