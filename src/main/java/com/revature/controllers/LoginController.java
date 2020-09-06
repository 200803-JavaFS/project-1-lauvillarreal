package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;

public class LoginController {	
	
	private static LoginService ls = new LoginService();
	private static ObjectMapper om = new ObjectMapper();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		if(req.getMethod().equals("GET")) {

			if(req.getParameterMap().containsKey("username") && req.getParameterMap().containsKey("password")) {

				LoginDTO u = new LoginDTO();
				u.setUsername(req.getParameter("username"));
				u.setPassword(req.getParameter("password"));
				
				if(ls.login(u)) {
					HttpSession session = req.getSession();
					session.setAttribute("user", 1);
					session.setAttribute("loggedin", true );
					res.setStatus(200);
					res.getWriter().println("Login Sucessful");
				} else {
					HttpSession session = req.getSession(false);
					if (session != null) {
						session.invalidate();
					}
					res.setStatus(401);
					res.getWriter().println("Login Failed");
				}
			}
		}else if(req.getMethod().equals("POST")) {
			
			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			String body = new String(sb);
			LoginDTO user = om.readValue(body, LoginDTO.class);
			if(ls.login(user)) {
				HttpSession session = req.getSession();
				session.setAttribute("user", 1);
				session.setAttribute("loggedin", true );
				res.setStatus(200);
				res.getWriter().println("Login Sucessful");
			} else {
				HttpSession session = req.getSession(false);
				if (session != null) {
					session.invalidate();
				}
				res.setStatus(401);
				res.getWriter().println("Login Failed");
			
			}
		}
	}
		public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
			HttpSession session = req.getSession(false);

			if (session != null) {
				User user = (User) session.getAttribute("user");
				session.invalidate();
				res.setStatus(200);
				res.getWriter().println(user.getUsername() + " has logged out successfully");
			} else {
				res.setStatus(400);
				res.getWriter().println("You must be logged in to logout!");
			}
		}
	

}
