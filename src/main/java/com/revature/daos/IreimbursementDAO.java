
package com.revature.daos;

import java.util.List;

import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ResolvedDTO;


public interface IreimbursementDAO {

	
	public boolean addReimbursementTicket(Reimbursement reim);
	public List<Reimbursement> viewAllTickets();
	public Reimbursement viewPendingTicketByID(int id);
	public boolean updateReimbursementTicket(Reimbursement reim);
	public List<Reimbursement> viewAllTicketsByUsername(String username);
	public boolean addResolved(ResolvedDTO info, LoginDTO user);
	
}
