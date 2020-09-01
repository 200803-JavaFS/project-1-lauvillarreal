
package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface IreimbursementDAO {

	
	public boolean addReimbursementTicket(Reimbursement reim);
	public List<Reimbursement> viewAllTickets();
	public Reimbursement viewPendingTicketByID(int id);
	public boolean updateReimbursementTicket(Reimbursement reim);
	
}
