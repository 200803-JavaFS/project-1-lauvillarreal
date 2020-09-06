package com.revature.daos;

import com.revature.models.Role;

public interface IroleDAO {
	
	public boolean addRole(Role role);
	public Role getRoleByID(int id);
	public Role getRoleByName(String name);
	public boolean updateRole(Role role);
	boolean addRole(String role);
}
