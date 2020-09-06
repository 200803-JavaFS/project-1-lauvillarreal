package com.revature.daos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class userDAO implements IuserDAO {
	
	private static final Logger log = LogManager.getLogger(reimbursementDAO.class);

	public userDAO() {
		super();
	}
	@Override
	public boolean addUser(User user) {
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		try {
			IroleDAO rDAO = new roleDAO();
			rDAO.addRole(user.getRoleID());
			session.saveOrUpdate(user);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			log.info("Cannot add User");
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		}
	@Override
	public User getUserByUsername(String username) {
		Session session = HibernateUtil.getSession();
		
		User user = session.createQuery("FROM User WHERE username='" + username + "'", User.class).list().get(0);
		return user;
	}
	
	@Override
	public boolean updateUser(User user) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.merge(user);
		} catch (HibernateException e) {
			log.info("Could not update User");
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public User getUserByEmail(String email) {
		Session session = HibernateUtil.getSession();
		
		User user = session.get(User.class, email);
		return user;	}
}
