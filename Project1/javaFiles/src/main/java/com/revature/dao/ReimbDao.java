package com.revature.dao;

import java.util.List;

import com.revature.model.Reimb;


public interface ReimbDao {
	ReimbDao currentImplementation = new ReimbDaoJdbc();

	List<Reimb> findAll();
	
	int addReimb(Reimb r);

}
