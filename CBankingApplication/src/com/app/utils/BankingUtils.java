package com.app.utils;

import java.time.LocalDate;

import com.app.custom_exception.BankingException;
import com.app.entity.AcType;
import com.app.entity.BankAccount;
import com.app.validation.BankingValidations;

public class BankingUtils 
{
	//validate all account opening details
	public static BankAccount validateAccountOpenDetails(BankAccount[] accounts, int acctNo, String firstName, String lastName, String acType,String dob, String creationDate, double balance) throws BankingException 
	{
		BankingValidations.validateAccountNumber(accounts,acctNo);
		AcType type=BankingValidations.validateAccountType(acType.toUpperCase());
		LocalDate dobdate=BankingValidations.validateAccountDOB(dob);
		LocalDate cDate=BankingValidations.validateAccountCreateDate(creationDate);
		BankingValidations.validateAccountBalance(balance);
		BankAccount acct=new BankAccount(acctNo,firstName,lastName,type,dobdate,cDate,balance);
		return acct;
	}
	
	//deposite amount in account
	public static void depositeAmount(BankAccount[] accounts, int acctNo, double amount) throws BankingException
	{
		BankAccount acct=BankingValidations.checkAccountNumber(accounts,acctNo);
		acct.setBalance(acct.getBalance()+amount);
		System.out.println("Amount deposited succefully...........");
	}
	
	//withdraw amount
	public static void withdrawAmount(BankAccount[] accounts, int acctNo, double amount) throws BankingException 
	{
		BankAccount acct=BankingValidations.checkAccountNumber(accounts,acctNo);
		BankingValidations.validateAccountbalance(acct,amount);
		acct.setBalance(acct.getBalance()-amount);
		System.out.println("Amount withdraw succefully...........");
	}
	
	//transfer fund from source to destination
	public static void fundTransfer(BankAccount[] accounts, int sAcctNo, int dAcctNo, double amount) throws BankingException 
	{
		BankAccount SourceAcct=BankingValidations.checkAccountNumber(accounts,sAcctNo);
		BankingValidations.validateAccountbalance(SourceAcct,amount);
		SourceAcct.setBalance(SourceAcct.getBalance()-amount);
		
		BankAccount DestinationAcct=BankingValidations.checkAccountNumber(accounts,dAcctNo);
		DestinationAcct.setBalance(DestinationAcct.getBalance()+amount);
		System.out.println("Fund transfer succefully...........");	
	}

	
	

}
