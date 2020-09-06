package com.revature.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="ers_reimbursement")
public class Reimbursement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reim_id", nullable=false)
	private int reimID;
	@Column(name="reim_amount", nullable=false)
	private double reimAmount;
	@Column(name="reim_submitted", nullable=false)
	private Timestamp reimSubmitted;
	@Column(name="reim_resolved")
	private Timestamp reimResolved;
	@Column(name= "reim_description")
	private String reimDescription;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reim_author_fk", nullable=false)
	private User reimAuthor;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reim_resolver_fk")
	private User reimResolver;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reim_status_id_fk", nullable=false)
	private Status reimStatus;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="reim_type_id_fk", nullable=false)
	private Type reimType;
	

	public Reimbursement() {
	}

	
	public Reimbursement(double reimAmount, Timestamp reimSubmitted, String reimDescription, User reimAuthor,
			Status reimStatus, Type reimType) {
		super();
		this.reimAmount = reimAmount;
		this.reimSubmitted = reimSubmitted;
		this.reimDescription = reimDescription;
		this.reimAuthor = reimAuthor;
		this.reimStatus = reimStatus;
		this.reimType = reimType;
	}


	public Reimbursement(double reimAmount, Timestamp reimSubmitted, Timestamp reimResolved, String reimDescription,
			User reimAuthor, User reimResolver, Status reimStatus, Type reimType) {
		super();
		this.reimAmount = reimAmount;
		this.reimSubmitted = reimSubmitted;
		this.reimResolved = reimResolved;
		this.reimDescription = reimDescription;
		this.reimAuthor = reimAuthor;
		this.reimResolver = reimResolver;
		this.reimStatus = reimStatus;
		this.reimType = reimType;
	}


	public Reimbursement(int reimID, double reimAmount, Timestamp reimSubmitted, Timestamp reimResolved, User author,
			User resolver, com.revature.models.Status status, com.revature.models.Type type) {
		super();
		this.reimID = reimID;
		this.reimAmount = reimAmount;
		this.reimSubmitted = reimSubmitted;
		this.reimResolved = reimResolved;
		reimAuthor = author;
		reimResolver = resolver;
		reimStatus = status;
		reimType = type;
	}

	
	public int getReimID() {
		return reimID;
	}


	public void setReimID(int reimID) {
		this.reimID = reimID;
	}


	public double getReimAmount() {
		return reimAmount;
	}


	public void setReimAmount(double reimAmount) {
		this.reimAmount = reimAmount;
	}


	public Timestamp getReimSubmitted() {
		return reimSubmitted;
	}


	public void setReimSubmitted(Timestamp reimSubmitted) {
		this.reimSubmitted = reimSubmitted;
	}


	public Timestamp getReimResolved() {
		return reimResolved;
	}


	public void setReimResolved(Timestamp reimResolved) {
		this.reimResolved = reimResolved;
	}


	public User getAuthor() {
		return reimAuthor;
	}


	public void setAuthor(User author) {
		reimAuthor = author;
	}


	public User getResolver() {
		return reimResolver;
	}


	public void setResolver(User resolver) {
		reimResolver = resolver;
	}


	public Status getStatus() {
		return reimStatus;
	}


	public void setStatus(Status status) {
		reimStatus = status;
	}


	public Type getType() {
		return reimType;
	}


	public void setType(Type type) {
		reimType = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((reimAuthor == null) ? 0 : reimAuthor.hashCode());
		result = prime * result + reimID;
		result = prime * result + ((reimResolved == null) ? 0 : reimResolved.hashCode());
		result = prime * result + ((reimResolver == null) ? 0 : reimResolver.hashCode());
		result = prime * result + ((reimStatus == null) ? 0 : reimStatus.hashCode());
		result = prime * result + ((reimSubmitted == null) ? 0 : reimSubmitted.hashCode());
		result = prime * result + ((reimType == null) ? 0 : reimType.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(reimAmount) != Double.doubleToLongBits(other.reimAmount))
			return false;
		if (reimAuthor == null) {
			if (other.reimAuthor != null)
				return false;
		} else if (!reimAuthor.equals(other.reimAuthor))
			return false;
		if (reimID != other.reimID)
			return false;
		if (reimResolved == null) {
			if (other.reimResolved != null)
				return false;
		} else if (!reimResolved.equals(other.reimResolved))
			return false;
		if (reimResolver == null) {
			if (other.reimResolver != null)
				return false;
		} else if (!reimResolver.equals(other.reimResolver))
			return false;
		if (reimStatus == null) {
			if (other.reimStatus != null)
				return false;
		} else if (!reimStatus.equals(other.reimStatus))
			return false;
		if (reimSubmitted == null) {
			if (other.reimSubmitted != null)
				return false;
		} else if (!reimSubmitted.equals(other.reimSubmitted))
			return false;
		if (reimType == null) {
			if (other.reimType != null)
				return false;
		} else if (!reimType.equals(other.reimType))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Reimbursement [reimID=" + reimID + ", reimAmount=" + reimAmount + ", reimSubmitted=" + reimSubmitted
				+ ", reimResolved=" + reimResolved + ", reimAuthor=" + reimAuthor + ", reimResolver=" + reimResolver
				+ ", reimStatus=" + reimStatus + ", reimType=" + reimType + "]";
	}


	
	



}
