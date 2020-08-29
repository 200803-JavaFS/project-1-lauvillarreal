package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursement_status")
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reim_status_id", nullable=false)
	private int statusID;
	@Column(name="reim_status", nullable=false)
	private String status;
	@OneToMany(mappedBy="reimStatus", fetch=FetchType.EAGER)
	private List<Reimbursement> statusList;
	
	public Status() {
	}

	public Status(int statusID, String status) {
		super();
		this.statusID = statusID;
		this.status = status;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusID;
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
		Status other = (Status) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusID != other.statusID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Status [statusID=" + statusID + ", status=" + status + "]";
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
