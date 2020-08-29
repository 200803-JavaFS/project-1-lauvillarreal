package com.revature.daos;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Role;
import com.revature.utils.HibernateUtil;

public class roleDAO {

	public roleDAO() {
		super();
	}
	public static void insert(Role role) {
		Session ses = HibernateUtil.getSession();
		
		Transaction tx = ses.beginTransaction();
		
		ses.save(role);
		
		tx.commit();
	}

}
