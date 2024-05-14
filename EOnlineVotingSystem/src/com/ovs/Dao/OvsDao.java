package com.ovs.Dao;

import java.sql.SQLException;

import com.ovs.entities.User;

public interface OvsDao 
{
	String voterRegistration(User newVoter) throws SQLException;
	
	User voterLogin(String email,String password) throws SQLException;
	
	void listCandidates() throws SQLException;
	
	String registerVote(int vid,int cid,String fname, String lname) throws SQLException;
	
	User AdminLogin(String email,String password) throws SQLException;
	
	void viewTWoTopCandidate()throws SQLException;
	
	void viewReportByPartywise()throws SQLException;
	
	String deleteVoter(int id)throws SQLException;
	
	String passswordUpdation(String email,String password,String newPassword)throws SQLException;

}
