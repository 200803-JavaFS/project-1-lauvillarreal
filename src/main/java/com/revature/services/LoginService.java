package com.revature.services;


import com.revature.daos.userDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class LoginService {	
	
	User sqlUser= new User();
	userDAO uDAO = new userDAO();
	User sqlUser2 = new User();
	
	public boolean login(LoginDTO user) {


		sqlUser = uDAO.getUserByUsername(user.getUsername());
		

		if (user.getUsername().equals(sqlUser.getUsername())) {
			if(user.getPassword().equals(sqlUser.getPassword())) {
				System.out.println("user already exists");
				return true;
			}
		} else {
		
			uDAO.addUser(user);
			System.out.println("doesnt exists, will user");
			return true;	
		}
		return false;
	}

}
