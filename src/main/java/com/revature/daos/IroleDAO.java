package com.revature.daos;

import com.revature.models.Role;

public interface IroleDAO {
	
	public boolean addRole(Role role);
	public Role getRoleByID(int id);
	public boolean updateRole(Role role);
}
