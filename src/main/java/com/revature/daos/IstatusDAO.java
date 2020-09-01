package com.revature.daos;

import com.revature.models.Status;


public interface IstatusDAO {

	public boolean addStatus(Status status);
	public boolean updateStatus(Status status);
	public Status getStatusById(int id);
}
