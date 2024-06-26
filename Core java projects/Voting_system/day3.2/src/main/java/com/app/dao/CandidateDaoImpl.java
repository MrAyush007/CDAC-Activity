package com.app.dao;

import static com.app.utils.DBUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.entities.Candidate;

public class CandidateDaoImpl implements CandidateDao {
	private Connection cn;
	private PreparedStatement pst1, pst2,pst3,pst4;

	public CandidateDaoImpl() throws SQLException {
		// open cnnectionn
		cn = getConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst3 =  cn.prepareStatement("select * from candidates order by votes desc limit 2");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		pst4 = cn.prepareStatement("select party,sum(votes) from candidates group by party");
		System.out.println("candidate dao created....");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> candidateList = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				candidateList.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidateList;
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		// set IN param : candidate id
		pst2.setInt(1, candidateId);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Votes updated...";
		return "Votes updation failed !!!!!!!!!!!!";
	}


	@Override
	public List<Candidate> showTopCandidates() throws SQLException {
		List<Candidate> candidateList = new ArrayList<>();
		try (ResultSet rst = pst3.executeQuery()) {
			while (rst.next())
				candidateList.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candidateList;
	}
	
	
	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		
	}

	@Override
	public Map<String, Integer> getPartyWiseVotes() throws SQLException {
		Map<String, Integer> candidateMap = new HashMap();
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				candidateMap.put(rst.getString(1), rst.getInt(2));
		}
		return candidateMap;
	}

}
