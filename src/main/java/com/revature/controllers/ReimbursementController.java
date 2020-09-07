package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.IreimbursementDAO;
import com.revature.daos.reimbursementDAO;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ResolvedDTO;
import com.revature.models.WebsiteInfoDTO;
import com.revature.services.ReimbursementService;


public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();
	IreimbursementDAO reimDAO = new reimbursementDAO();
	private static ObjectMapper om = new ObjectMapper();
	private static final Logger log = LogManager.getLogger(ReimbursementController.class);
	
	public void getReimbursement(HttpServletResponse res, int id) {
		// TODO Auto-generated method stub
		
	}

	public void getAllReimbursements(HttpServletResponse res) throws IOException{
		List<Reimbursement> all = reimDAO.viewAllTickets();
		System.out.println("rc view all tickets");
		System.out.println(all);
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
		
		System.out.println("<3" + info + "<3");
		
		if (rs.addWebsiteInfo(info)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement was created!");
		} else {
			res.setStatus(403);
		}
		
	}
	

	public void updateReimbursementResolved(HttpServletResponse res, HttpServletRequest req, LoginDTO user) throws IOException {
		BufferedReader reader = req.getReader();
		
		StringBuilder s = new StringBuilder();
		
		String line = reader.readLine();
		
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = new String(s);
		
		System.out.println(body);
		
		ResolvedDTO info = om.readValue(body, ResolvedDTO.class);
		
		System.out.println("<3" + info + "<3");
		
		if (rs.addResolvedInfo(info, user)) {
			res.setStatus(201);
			res.getWriter().println("Reimbursement was updated!");
		} else {
			res.setStatus(403);
		}
	}

	public void getAllReimbursementsByUsername(HttpServletResponse res, String username) throws JsonProcessingException, IOException {
		List<Reimbursement> all = reimDAO.viewAllTicketsByUsername(username);
		log.info("rc view all tickets By username");
		System.out.println(all);
		res.getWriter().println(om.writeValueAsString(all));
		res.setStatus(200);
		
		
	}

}
