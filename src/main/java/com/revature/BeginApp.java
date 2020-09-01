package com.revature;

import com.revature.daos.IreimbursementDAO;
import com.revature.daos.IroleDAO;
import com.revature.daos.IstatusDAO;
import com.revature.daos.ItypeDAO;
import com.revature.daos.IuserDAO;
import com.revature.daos.reimbursementDAO;
import com.revature.daos.roleDAO;
import com.revature.daos.userDAO;
import com.revature.daos.*;

public class BeginApp {
	
	public static IroleDAO roleDao = new roleDAO();
	public static IuserDAO userDao = new userDAO();
	public static IreimbursementDAO reimDAO = new reimbursementDAO();
	public static IstatusDAO statusDAO = new statusDAO();
	public static ItypeDAO typeDAO = new typeDAO();

	public void application() {
		
	
	}

}
