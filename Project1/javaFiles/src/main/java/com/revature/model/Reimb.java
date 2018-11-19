package com.revature.model;

public class Reimb {
	
	private int reimb_id;
	private int reimb_amount;
	private String reimb_description;
	private int reimb_author;
	

	public Reimb() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimb(int reimb_id, int reimb_amount, String reimb_description, int reimb_author) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public int getReimb_amount() {
		return reimb_amount;
	}


	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}


	public String getReimb_description() {
		return reimb_description;
	}


	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}


	public int getReimb_author() {
		return reimb_author;
	}


	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimb_amount;
		result = prime * result + reimb_author;
		result = prime * result + ((reimb_description == null) ? 0 : reimb_description.hashCode());
		result = prime * result + reimb_id;
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
		Reimb other = (Reimb) obj;
		if (reimb_amount != other.reimb_amount)
			return false;
		if (reimb_author != other.reimb_author)
			return false;
		if (reimb_description == null) {
			if (other.reimb_description != null)
				return false;
		} else if (!reimb_description.equals(other.reimb_description))
			return false;
		if (reimb_id != other.reimb_id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Reimb [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_description="
				+ reimb_description + ", reimb_author=" + reimb_author + "]";
	}

	
	

}

	
	
	
	
	

