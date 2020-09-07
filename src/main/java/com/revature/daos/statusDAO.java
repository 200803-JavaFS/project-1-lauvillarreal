package com.revature.daos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Status;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class statusDAO implements IstatusDAO {
	private static final Logger log = LogManager.getLogger(reimbursementDAO.class);

	public statusDAO() {
		super();
	}

	@Override
	public boolean addStatus(Status status) {
		Session ses = HibernateUtil.getSession();
		
		try {
			ses.save(status);
			return true;	
	} catch (HibernateException e) {
		log.info("Could not add Status");
		e.printStackTrace();
		return false;
	}
	
	}

	@Override
	public boolean updateStatus(Status status) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.merge(status);
		} catch (HibernateException e) {
			log.info("Could not update Type");
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Status getStatusByStatusString(String status) {
		Session session = HibernateUtil.getSession();
		Status status2 = session.createQuery("FROM Status WHERE status='" + status + "'", Status.class).list().get(0);
				
		return status2;
	}

	@Override
	public Status getStatusByName(String name) {
		Session ses = HibernateUtil.getSession();
		
		Status s = ses.get(Status.class, name);
		
		return s;
	}

}
