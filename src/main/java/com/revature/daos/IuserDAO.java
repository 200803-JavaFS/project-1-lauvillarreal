package com.revature.daos;

import com.revature.models.User;

public interface IuserDAO {

	public boolean addUser(User user);
	public User getUserByUsername(String username);
	public User getUserByEmail(String email);
	public boolean updateUser(User user);
}
