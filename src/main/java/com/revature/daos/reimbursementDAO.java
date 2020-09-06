package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.utils.HibernateUtil;

public class reimbursementDAO implements IreimbursementDAO {
	
	private static final Logger log = LogManager.getLogger(reimbursementDAO.class);

	public reimbursementDAO() {
		super();
	}

	@Override
	public boolean addReimbursementTicket(Reimbursement reim) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		try {
			IuserDAO uDAO = new userDAO();
			IuserDAO uDAO2 = new userDAO();
			ItypeDAO tDAO = new typeDAO();
			IstatusDAO sDAO = new statusDAO();
			sDAO.addStatus(reim.getStatus());
			tDAO.addType(reim.getType());
			uDAO2.addUser(reim.getAuthor());
			if(reim.getResolver() != null) {
			uDAO.getUserByUsername(reim.getResolver().getUsername());
			} else {
				log.info("A resolver has not yet been added");
			}
			
			session.saveOrUpdate(reim);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			log.info("Cannot add Reimbursement Ticket");
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		}

	@Override
	public List<Reimbursement> viewAllTickets() {
		Session session = HibernateUtil.getSession();
		
		List<Reimbursement> list = session.createQuery("FROM Reimbursement").list();
		return list;
	}

	@Override
	public Reimbursement viewPendingTicketByID(int id) {
		Session session = HibernateUtil.getSession();
		Reimbursement reim = session.get(Reimbursement.class, id);
				
		return reim;
	}

	@Override
	public boolean updateReimbursementTicket(Reimbursement reim) {
		Session session = HibernateUtil.getSession();
		
		try {
			session.merge(reim);
			return true;
		} catch (HibernateException e) {
			log.info("Could not update Reimbursement ticket");
			return false;
		}
		
	}

}
