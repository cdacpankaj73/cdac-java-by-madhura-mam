package com.ovs.dbutils;

import java.sql.*;

public class DbUtils 
{
	public static Connection conn;
	public static final String DB_URL;
	public static final String USERNAME;
	public static final String PASSWORD;
	
	static
	{
		DB_URL="jdbc:mysql://localhost:3306/iacsd_mar24";
		USERNAME="root";
		PASSWORD="";
	}
	
	public static Connection openConnection() throws SQLException
	{
		conn=DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		return conn;
		
	}
	
	public static void  closeConnection() throws SQLException
	{
		if(conn!=null)
			conn.close();
		System.out.println("Database connection closed...");
		
	}

}
