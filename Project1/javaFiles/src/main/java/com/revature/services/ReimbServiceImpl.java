package com.revature.services;

import java.util.List;

import com.revature.dao.ReimbDao;
import com.revature.model.Reimb;

public class ReimbServiceImpl implements ReimbService{
	private ReimbDao rd = ReimbDao.currentImplementation;

	public List<Reimb> findAll() {
		return rd.findAll();
	}

	public int addRiemb(Reimb r) {
		return rd.addReimb(r);
	}
}
