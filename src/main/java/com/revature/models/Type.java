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
@Table(name="ers_reimbursement_type")
public class Type {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reim_type_id", nullable=false)
	private int typeID;
	@Column(name="reim_type", nullable=false)
	private String type;
	@OneToMany(mappedBy="reimType", fetch=FetchType.EAGER)
	private List<Reimbursement> typeList;
	
	public Type() {
	}

	public Type(int typeID, String type) {
		super();
		this.typeID = typeID;
		this.type = type;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + typeID;
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
		Type other = (Type) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeID != other.typeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Type [typeID=" + typeID + ", type=" + type + "]";
	}
	
	
}
