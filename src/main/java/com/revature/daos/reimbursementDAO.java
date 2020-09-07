package com.revature.daos;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ResolvedDTO;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class reimbursementDAO implements IreimbursementDAO {
	
	private static final Logger log = LogManager.getLogger(reimbursementDAO.class);
	IstatusDAO sDAO = new statusDAO();
	IuserDAO uDAO = new userDAO();
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
			log.info("Added reimbursement");
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
		
		log.info("Viewing all reimbursement tickets");
		System.out.println(list + " ");
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


	@Override
	public List<Reimbursement> viewAllTicketsByUsername(String username) {
		Session session = HibernateUtil.getSession();
		User user = uDAO.getUserByUsername(username);
		
		List<Reimbursement> list = session.createQuery("FROM Reimbursement WHERE reimAuthor = '" + user.getUserID() + "'", Reimbursement.class).list();

		log.info("Viewing all reimbursement tickets");
		System.out.println(list + " ");
		return list;
	}

	@Override
	public boolean addResolved(ResolvedDTO info,  LoginDTO user) {
		Reimbursement reim = viewPendingTicketByID(info.id);
		System.out.println("yeahhh reim"+ reim );
		Session session = HibernateUtil.getSession();
		//Timestamp time = new Timestamp(System.currentTimeMillis());
		Status status = sDAO.getStatusByStatusString(info.status);
		User resolver = uDAO.getUserByUsername(user.getUsername());
		reim.setStatus(status);
		reim.setResolver(resolver);
		reim.setReimResolved(info.date);
;
		try {
			session.merge(reim);
//			ses.createQuery("UPDATE Reimbursement SET reimResolved = '" + info.date + "' WHERE reimID = '" + info.id + "'");
//			ses.createQuery("UPDATE Reimbursement SET reimStatus = '" + status.getStatusID()+ "' WHERE reimID = '" + info.id + "'");
//			ses.createQuery("UPDATE Reimbursement SET reimResolver = '" + resolver.getUserID() + "' WHERE reimID = '" + info.id + "'");
//			System.out.println("yyeeeeeeeeeeeeeeeeeeeeeeeeaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//			
			
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

}
