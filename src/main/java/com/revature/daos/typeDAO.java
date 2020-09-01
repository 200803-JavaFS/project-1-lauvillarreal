package com.revature.daos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import com.revature.models.Type;
import com.revature.utils.HibernateUtil;

public class typeDAO implements ItypeDAO {
	
	private static final Logger log = LogManager.getLogger(reimbursementDAO.class);

	public typeDAO() {
		super();
	}

	@Override
	public boolean addType(Type type) {
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.save(type);
			return true;	
	} catch (HibernateException e) {
		log.info("Could not add Type");
		e.printStackTrace();
		return false;
	}
	}

	@Override
	public boolean updateType(Type type) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.merge(type);
		} catch (HibernateException e) {
			log.info("Could not update Type");
			e.printStackTrace();
		}
		return false;
	
	}

	@Override
	public Type getTypeByID(int id) {
		Session session = HibernateUtil.getSession();
		Type type = session.get(Type.class, id);
				
		return type;
	}

}
