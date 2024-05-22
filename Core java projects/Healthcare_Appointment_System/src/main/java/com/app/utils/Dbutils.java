package com.app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutils {
	private static Connection connection;
	
	public static void openConnection(String Db_URL , String user_info , String password) throws SQLException{
		//make a conntection through Driver manager with SQL 
		connection=DriverManager.getConnection(Db_URL,user_info,password);
		System.out.println("connection done");
	}
	
	public static Connection getConnection() {
		return connection;	
	}
	
	public static void closeConnection() throws SQLException {
		if(connection!=null){
			System.out.println("connection DB close");
			connection.close();
		}
//		System.out.println("connection establised");
	}
	
}
