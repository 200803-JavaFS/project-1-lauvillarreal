package com.revature.services;

import java.sql.Timestamp;
import java.util.List;

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
import com.revature.models.Reimbursement;
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
	
	
	
	public boolean addWebsiteInfo(WebsiteInfoDTO info) {
		Reimbursement reimInfo;
		Type typeInfo;
		User userInfo;
		Role roleInfo;
		String statusString = "created";
		Timestamp submitted;
		Status statusInfo;
		
		if (info.type != null && info.email != null && info.role != null) {
			typeInfo = tDAO.getTypeByName(info.type);
			statusInfo = sDAO.getStatusByName(statusString);
			userInfo = uDAO.getUserByEmail(info.email);
			roleInfo = rDAO.getRoleByName(info.role);
			reimInfo = new Reimbursement(info.amount, info.date, info.description, userInfo, statusInfo, typeInfo);
			
		} else {
			reimInfo = null;
			System.out.println("could not add website info because not enough info given");
			return false;
		}
		return reimDAO.addReimbursementTicket(reimInfo);
		
		
	}
	
		
}
