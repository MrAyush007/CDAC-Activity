package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import static com.app.utils.Dbutils.*;
import com.app.entities.Appoinment;

public class AppoinmentDaoImpl implements Appinment_dao {
	Connection cn;
	PreparedStatement ps1,ps2,ps3,ps4;
	
	public AppoinmentDaoImpl() throws SQLException {
		super();
		cn=getConnection();
		ps1=cn.prepareStatement("select a.*,d.name from appoinments a join patient b on a.id=b.id join doctor d on a.doc_id=d.doc_id where b.email=?");
		ps2=cn.prepareStatement("delete from appoinments where appoinment_id=?");
		ps3=cn.prepareStatement("insert into appoinments(appoinment_id,doc_id,id,appoinment_date,appoinment_time) values(default,?,?,?,?)");
		ps4 = cn.prepareStatement("select appoinment_time from appoinments");
	}

	@Override
	public List<Appoinment> showPatientAppoinments(String email) throws SQLException {
		List<Appoinment> list = new ArrayList<>();
		ps1.setString(1, email);
		try(ResultSet rst = ps1.executeQuery()){
			while(rst.next()){	
				list.add(new Appoinment(rst.getInt(1),rst.getInt(2),rst.getInt(3),rst.getDate(4),rst.getTime(5),rst.getString(6)));
			}
		}
		return list;
	}
	
	public void cleanUP() throws SQLException{
		if(ps1!=null)
			ps1.close();
		System.out.println("statement close");
	}

	@Override
	public boolean deleteAppoinment(int num) throws SQLException {
		ps2.setInt(1, num);
		int result = ps2.executeUpdate();
		
		if(result!=0){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean addAppoinment(Appoinment a1) throws SQLException {
		ps3.setInt(2,a1.getDoctorId());
		ps3.setInt(1, a1.getPatientId());
		ps3.setDate(3,a1.getAppointmentDate());
		ps3.setTime(4, a1.getAppointmentTime());
		
		int num = ps3.executeUpdate();
		
		if(num!=0) {
			return true;
		}
		return false;
	}

	@Override
	public List<LocalTime> timeList() throws SQLException {
		List<LocalTime> ans= null;
		try(ResultSet rst = ps4.executeQuery()) {
			while(rst.next()) {
				ans.add(LocalTime.parse(rst.getString(1)));
			}
		}
		return ans;
	}
	
}