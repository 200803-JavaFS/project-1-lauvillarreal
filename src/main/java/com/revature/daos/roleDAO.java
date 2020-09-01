package com.revature.daos;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Role;
import com.revature.utils.HibernateUtil;

public class roleDAO implements IroleDAO {
	private static final Logger log = LogManager.getLogger(reimbursementDAO.class);


	public roleDAO() {
		super();
	}
	@Override
	public boolean addRole(Role role) {
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.save(role);
			return true;	
	} catch (HibernateException e) {
		log.info("Could not add Role");
		e.printStackTrace();
		return false;
	}
	}
	
	@Override
	public Role getRoleByID(int id) {
		Session session = HibernateUtil.getSession();
		Role role = session.get(Role.class, id);
				
		return role;
	}
	@Override
	public boolean updateRole(Role role) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.merge(role);
		} catch (HibernateException e) {
			log.info("Could not update Type");
			e.printStackTrace();
		}
		return false;
	}

}
