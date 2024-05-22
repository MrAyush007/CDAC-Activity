package com.app.dao;

import static com.app.utils.Dbutils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Doctor;
import com.app.utils.Specialization;

public class DoctorDaoImpl implements Doctor_dao{
	Connection cn;
	PreparedStatement ps1,ps2;
	
	
	public DoctorDaoImpl() throws SQLException {
		cn=getConnection();
		ps1 = cn.prepareStatement("select * from doctor");
		ps2 = cn.prepareStatement("select name from doctor where doc_id=?");
	}
	
	
	public void cleanUP() throws SQLException{
		if(ps1!=null)
			ps1.close();
		System.out.println("statement close");
	}


	


	@Override
	public List<Doctor> showDoctor() throws SQLException {
		List<Doctor> list = new ArrayList<>();
	try (ResultSet rst = ps1.executeQuery()){
		while(rst.next()) {
			list.add(new Doctor(rst.getInt(1),rst.getString(2) ,Specialization.valueOf(rst.getString(3))));
		}
		
	}
		return list;
	}


	@Override
	public String findDoctor(int doc_id) throws SQLException {
		ps2.setInt(1, doc_id);
		
		try(ResultSet rst = ps2.executeQuery()){
			rst.next();
			return rst.getString(1);
		}
	}
}
