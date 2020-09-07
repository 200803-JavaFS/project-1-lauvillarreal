package com.revature.services;


import com.revature.daos.IreimbursementDAO;
import com.revature.daos.IroleDAO;
import com.revature.daos.IstatusDAO;
import com.revature.daos.ItypeDAO;
import com.revature.daos.IuserDAO;
import com.revature.daos.reimbursementDAO;
import com.revature.daos.roleDAO;
import com.revature.daos.statusDAO;
import com.revature.daos.typeDAO;
import com.revature.daos.userDAO;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ResolvedDTO;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.Type;
import com.revature.models.User;
import com.revature.models.WebsiteInfoDTO;

public class ReimbursementService {
	private static IreimbursementDAO reimDAO = new reimbursementDAO();
	private static IroleDAO rDAO = new roleDAO();
	private static ItypeDAO tDAO = new typeDAO();
	private static IstatusDAO sDAO = new statusDAO();
	private static IuserDAO uDAO = new userDAO();
	
	Type typeInfo = new Type();
	User userInfo = new User();
	Role roleInfo = new Role();
	Status statusInfo = new Status();
	Reimbursement reimInfo = new Reimbursement();
	

	
	public boolean addWebsiteInfo(WebsiteInfoDTO info) {
		String statusString = "created";
		
		if (info.type != null ) {
			typeInfo.setType(info.type);
			statusInfo.setStatus(statusString);
			userInfo = uDAO.getUserByEmail(info.email);
	        reimInfo.setAuthor(userInfo);
			reimInfo = new Reimbursement(info.amount, info.date, info.description, userInfo, statusInfo, typeInfo);
			System.out.println(reimInfo);
			System.out.println(userInfo);
			System.out.println(roleInfo);
			
			
		} else {
			reimInfo = null;
			System.out.println("could not add website info because not enough info given");
			return false;
		}
		return reimDAO.addReimbursementTicket(reimInfo);
	
		
	}



	public boolean addResolvedInfo(ResolvedDTO info, LoginDTO user) {
		if(reimDAO.addResolved(info, user)) {
			return true;
		}
		return false;
	}



	
	
		
}
