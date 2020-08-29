package com.revature.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class userDAO {

	public userDAO() {
		super();
	}
	public void insert(User user) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		ses.save(user);
		tx.commit();
	}
	
	public User getUserByUsername(String username) {
		Session session = HibernateUtil.getSession();
		
		User user = session.get(User.class, username);
		return user;
	}
}
