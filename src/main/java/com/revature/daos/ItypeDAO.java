package com.revature.daos;

import com.revature.models.Type;

public interface ItypeDAO {
	
	public boolean addType(Type type);
	public boolean updateType(Type type);
	public Type getTypeByID(int id);
}


