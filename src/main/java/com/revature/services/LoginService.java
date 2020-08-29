package com.revature.services;


import com.revature.daos.userDAO;
import com.revature.models.User;

public class LoginService {	
	
	User sqlUser= new User();
	userDAO uDAO = new userDAO();
	
	public boolean login(User user) {


		sqlUser = uDAO.getUserByUsername("username");

		if (user.getUsername().equals(sqlUser.getUsername())) {
			if(user.getPassword().equals(sqlUser.getPassword())) {
				return true;
			}
		}
		return false;		
	}

}
