package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

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
import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;

public class Project1Test {
	
	String email = "lau@gmail.com";
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
	
	public static ReimbursementService rs = new ReimbursementService();
	
	
	
	@Test
	public void testAddReimbursement() {
		WebsiteInfoDTO web = new WebsiteInfoDTO("relocation", 900, null, "relocating to sf");
		System.out.println("Testing add Reimbursement with website info");
		Role r = rDAO.getRoleByID(1);
		Type t = tDAO.getTypeByID(1);
		System.out.println("testing getTypeByID");
		System.out.println("testing getRoleByID");
		typeInfo = new Type(1, "certification");
		User userInfo = uDAO.getUserByEmail(email);
		roleInfo = new Role(1,"employee");
		User u = new User(3,"lauvillarreal","password","lau","vill","lau@gmail.com",r);
		List<Reimbursement> reim = reimDAO.viewAllTickets();
		assertEquals(userInfo, u);
		assertEquals(r,roleInfo);
		assertEquals(t, typeInfo);
		System.out.println("testing view all reimbursements");
		assertTrue(reim!=null);

		System.out.println("testing getUserByEmail");
		
		
		}

}
