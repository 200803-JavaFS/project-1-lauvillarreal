package com.revature.daos;

import com.revature.models.User;

public interface IuserDAO {

	public boolean addUser(User user);
	public User getUserByUsername(String username);
	public boolean updateUser(User user);
}
