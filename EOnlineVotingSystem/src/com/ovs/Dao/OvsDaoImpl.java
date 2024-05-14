package com.ovs.Dao;

import java.sql.*;
import java.sql.SQLException;

import static com.ovs.dbutils.DbUtils.*;
import com.ovs.entities.User;

public class OvsDaoImpl implements OvsDao
{
	private Connection con;
	private PreparedStatement pst1, pst2, pst3,pst4,pst5,pst6,pst7,pst9;
	private CallableStatement pst8;

	
	public OvsDaoImpl() throws SQLException
	{
		con=openConnection();
		pst1=con.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		pst2=con.prepareStatement("select * from users where email=? and password=? and role='voter'");
		pst3=con.prepareStatement("select * from users where email=? and password=? and role='Admin'");
		pst4=con.prepareStatement("select * from candidates order by votes desc limit 2");
		pst5=con.prepareStatement("select party,sum(votes) as votes from candidates group by party");
		pst6=con.prepareStatement("delete from users where id=?");
		pst7=con.prepareStatement("update users set password=? where email=? and password=? and role='voter'");
		pst9=con.prepareStatement("select * from candidates");
		pst8=con.prepareCall("{? = CALL registerVote(?, ?)}");
	}

	@Override
	public String voterRegistration(User newVoter) throws SQLException 
	{
		
		pst1.setString(1, newVoter.getFirstName());
		pst1.setString(2, newVoter.getLastName());
		pst1.setString(3, newVoter.getEmail());
		pst1.setString(4, newVoter.getPassword());
		pst1.setDate(5, newVoter.getDob());
		pst1.setBoolean(6, newVoter.isStatus());
		pst1.setString(7, newVoter.getRole());
		int row=pst1.executeUpdate();
		if(row==1)
			return "voter register successfully.......";
		return "voter register failed.......!";
	}

	@Override
	public User voterLogin(String email, String password) throws SQLException {
		pst2.setString(1,email);
		pst2.setString(2,password);
		try(ResultSet rs=pst2.executeQuery())
		{
			if(rs.next())
			{
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getDate(6),
						rs.getBoolean(7), rs.getString(8));
			}
		}
		return null;
	}
	
	@Override
	public void listCandidates() throws SQLException 
	{
		try(ResultSet rs=pst9.executeQuery())
		{
			System.out.println("id \tname \tparty");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			
		}
		
	}
	
	@Override
	public String registerVote(int vid,int cid, String fname, String lname) throws SQLException 
	{
		pst8.registerOutParameter(1,Types.INTEGER);
		pst8.setInt(2,vid);
		pst8.setInt(3,cid);

		pst8.execute();
		if(pst8.getInt(1)==0)
			return "Hello , "+fname+" "+lname+"\nmessage:->You have casted a vote successfully.............";
		return "Hello , "+fname+" "+lname+"\nmessage:->You have already voted !!!!!!!!!!!!!!";
	}

	@Override
	public User AdminLogin(String email, String password) throws SQLException {
		pst3.setString(1,email);
		pst3.setString(2,password);
		try(ResultSet rs=pst3.executeQuery())
		{
			if(rs.next())
			{
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getDate(6),
						rs.getBoolean(7), rs.getString(8));
			}
		}
		return null;
	}

	@Override
	public void viewTWoTopCandidate() throws SQLException
	{
		try(ResultSet rs=pst4.executeQuery())
		{
			System.out.println("id \tname \tparty \tvotes");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
			}
			
		}
		
	}

	@Override
	public void viewReportByPartywise() throws SQLException 
	{
		try(ResultSet rs=pst5.executeQuery())
		{
			System.out.println("party \t votes");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
			}
		}
		
	}

	@Override
	public String deleteVoter(int id) throws SQLException 
	{
		pst6.setInt(1,id);
		int row=pst6.executeUpdate();
		if(row==1)
			return "voter delete successfully.......";
		return "voter deletion failed.......!";
	}

	@Override
	public String passswordUpdation(String email, String password, String newPassword) throws SQLException {
		pst7.setString(2,email);
		pst7.setString(1,newPassword);
		pst7.setString(3,password);
		
		int row=pst7.executeUpdate();
		if(row> 0)
			return "Update voter password successfully.......";
		return "update voter password unsuccessful";
	}

	

	
	
}
