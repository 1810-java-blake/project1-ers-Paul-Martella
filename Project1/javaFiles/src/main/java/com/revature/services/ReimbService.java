package com.revature.services;

import java.util.List;

import com.revature.model.Reimb;

public interface ReimbService {
	ReimbService currentImplementation = new ReimbServiceImpl();

	List<Reimb> findAll();
	
	int addRiemb(Reimb r);

}
