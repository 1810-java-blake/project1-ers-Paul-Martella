package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimb;
import com.revature.utils.ConnectionUtil;

public class ReimbDaoJdbc implements ReimbDao{
	
	public List<Reimb> findAll() {
		// expected address jdbc:postgresql://project1.cetam09soh44.us-east-2.rds.amazonaws.com:5432/project1?user=testAccount&password=Nb2345rccddfd$sd";
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement s = conn.prepareStatement("SELECT * FROM ers_reimbursement;");
			ResultSet rs = s.executeQuery();
			
			//List<Reimb> reimb = new ArrayList<>();
		//	while (rs.next()) {
		//		reimb.add(new Reimb(rs.getInt("reimb_amount"), rs.getString("reimb_description"), rs.getInt("reimb_author")));
			//}
			//return reimb;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int addReimb(Reimb r) {
//		try (Connection conn = DriverManager.getConnection(dataSource)) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO ers_reimbursement (reimb_amount, reimb_description, flavorrating) VALUES (?, ? ,?)"
				, new String[] {"id"} // not required but if you want to get a value generated
				// by the db you need to specify the columns you want to view
			);
			ps.setInt(1, r.getReimb_amount());
			ps.setString(2, r.getReimb_description());
			ps.setInt(3, r.getReimb_author());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys(); // get a rs containing the columns for the record inserted based off string array above
			if (rs.next()) {
				int id = rs.getInt("id");
				r.setReimb_id(id);
				return id;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
