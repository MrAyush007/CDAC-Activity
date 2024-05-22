package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.app.utils.Dbutils.*;
import com.app.entities.Patient;

public class patientDaoImpl implements patient_dao {
	private Connection cn;
	private PreparedStatement ps1,ps2,ps3;
	
	
	public patientDaoImpl() throws SQLException{
		super();
		this.cn = getConnection();
		try {
			//for sign in
			ps1=cn.prepareStatement("select * from patient where email=? and password=?");
			//for sign up
			ps2= cn.prepareStatement("Insert into patient values(default,?,?,?,?)");
//			for email validate
			ps3 = cn.prepareStatement("select * from patient where email=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public Patient signIn(String email, String pass) throws SQLException {
		ps1.setString(1, email);
		ps1.setString(2, pass);
		try(ResultSet rst = ps1.executeQuery()){
			while(rst.next()){
				System.out.println("done");
				return new Patient(rst.getInt(1),rst.getString(2),email,pass,rst.getDate(5)); 
			}
		}
		return null;
	}

	public boolean emailDuplicate(String mail) throws SQLException
	{
		ps3.setString(1, mail);
		
		ResultSet rst = ps3.executeQuery();
		
		if(rst.next()) {
			return true;
		}
		return false;
	}
	
	@Override
	public String patientRegister(Patient p1) throws SQLException {
		//get data from p1(patient)
		ps2.setString(1, p1.getName());
		ps2.setString(2, p1.getEmail());
		ps2.setString(3, p1.getPassword());
		ps2.setDate(4,p1.getDob());
		
		int rows = ps2.executeUpdate();
		
		if(rows!=0)
			return "patient registerd";
		return "something wrong "; 
	}
	public void cleanUP() throws SQLException{
		if(ps1!=null)
			ps1.close();
		System.out.println("statement close");
	}
}
