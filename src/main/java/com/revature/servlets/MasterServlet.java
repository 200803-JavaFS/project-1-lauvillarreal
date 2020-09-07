package com.revature.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.LoginController;
import com.revature.models.User;
import com.revature.controllers.ReimbursementController;
import com.revature.daos.reimbursementDAO;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;

public class MasterServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	private static ReimbursementController rc = new ReimbursementController();
	private static LoginController lc = new LoginController();
	private static ObjectMapper om = new ObjectMapper();
	private static final Logger log = LogManager.getLogger(MasterServlet.class);
	LoginDTO user = new LoginDTO();
	

	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);

		final String URI = req.getRequestURI().replace("/reimbursement/", "");

		

		String[] portions = URI.split("/");

		System.out.println(Arrays.toString(portions));

		try {
			switch (portions[0]) {
			case "employee":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							rc.getReimbursement(res, id);
						} else if (portions.length == 1) {
							String username = user.getUsername();
							rc.getAllReimbursementsByUsername(res, username);
						}
					} else if (req.getMethod().equals("POST")) {
						System.out.println("Successfully in POST");
						rc.addReimbursement(req, res);
					}
					}
				 else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				
				}
				break;
			case "manager":
				if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
					if (req.getMethod().equals("GET")) {
						if (portions.length == 2) {
							int id = Integer.parseInt(portions[1]);
							rc.getReimbursement(res, id);
						} else if (portions.length == 1) {
						
							rc.getAllReimbursements(res);
						}
					} else if (req.getMethod().equals("POST")) {
						rc.updateReimbursementResolved(res,req,user);
						
					}
				}
				 else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				
				break;
			case "login":
				BufferedReader reader = req.getReader();
				StringBuilder sb = new StringBuilder();
				String line = reader.readLine();
				while(line != null) {
					sb.append(line);
					line = reader.readLine();
				}
				String body = new String(sb);
				user = om.readValue(body, LoginDTO.class);
				System.out.println(" ooooommmggggg it workedn");
				System.out.println(user);
				lc.login(req, res, user);
				break;
			case "logout":
				lc.logout(req, res);
				break;
			
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("The id you provided is not an integer");
			System.out.println("error in switch statement");
			log.info("error in switch statement");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
