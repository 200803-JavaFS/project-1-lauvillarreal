package com.revature.servlets;


import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
//import com.revature.models.User;
import com.revature.controllers.ReimbursementController;

public class MasterServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	private static ReimbursementController ac = new ReimbursementController();
	private static LoginController lc = new LoginController();

	public MasterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		// By default tomcat will send back a successful status code if it finds a
		// servlet method.
		// Because all requests will hit this method, we are defaulting to not found and
		// will override for success requests.
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
							ac.getReimbursement(res, id);
						} else if (portions.length == 1) {
							ac.getAllReimbursements(res);
						}
					} else if (req.getMethod().equals("POST")) {
						ac.addReimbursement(req, res);
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
							ac.getReimbursement(res, id);
						} else if (portions.length == 1) {
							ac.getAllReimbursements(res);
						}
					} else if (req.getMethod().equals("POST")) {
						ac.updateReimbursement();
						
					}
				}
				 else {
					res.setStatus(403);
					res.getWriter().println("You must be logged in to do that!");
				}
				
				break;
			case "login":
				lc.login(req, res);
				break;
			case "logout":
				lc.logout(req, res);
				break;
			
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("The id you provided is not an integer");
			System.out.println("error in switch statement");
			res.setStatus(400);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
