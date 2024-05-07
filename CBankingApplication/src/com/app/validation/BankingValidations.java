package com.app.validation;

import java.time.LocalDate;
import java.time.Period;

import com.app.custom_exception.BankingException;
import com.app.entity.AcType;
import com.app.entity.BankAccount;

public class BankingValidations
{
	public static final Double MIN_BAL=5000.0;

	//validate account number is already taken or not
	public static void validateAccountNumber(BankAccount[] accounts, int acctNo) throws BankingException 
	{
		BankAccount acct=new BankAccount(acctNo);
		for(BankAccount ba:accounts)
		{
			if(ba != null && ba.equals(acct))
				throw new BankingException("the Account Number is already taken try another........");
		}
	}
	
	//validate account type and parse it
	public static AcType validateAccountType(String acType) 
	{
		return AcType.valueOf(acType);
	}

	//validate age using dob date and parse it
	public static LocalDate validateAccountDOB(String dob) throws BankingException 
	{
		LocalDate dobDate=LocalDate.parse(dob);
		int age=Period.between(dobDate,LocalDate.now()).getYears();
		if(age<18)
			throw new BankingException("Your age less than 18........");
		return dobDate;
	}
	
	//validate account opening date is in current financial year parse it
	public static LocalDate validateAccountCreateDate(String creationDate) throws BankingException 
	{
		LocalDate cDate=LocalDate.parse(creationDate);
		if(cDate.isAfter(LocalDate.parse("2024-04-01")) && cDate.isBefore(LocalDate.parse("2025-03-31")))
			return cDate;
		throw new BankingException("Account creation date must be within current fintial year........");
		
	}
	
	
	//validate account opening balance gretater than 5000
	public static void validateAccountBalance(double balance) throws BankingException
	{
		if(balance<MIN_BAL)
			throw new BankingException("For account opening we need minimum 5000 balance........");
	}
	
	//validate account number and return account
	public static BankAccount checkAccountNumber(BankAccount[] accounts, int acctNo) throws BankingException
	{
		BankAccount acct=new BankAccount(acctNo);
		for(BankAccount ba:accounts)
		{
			if(ba != null &&  ba.equals(acct))
				return ba;
		}
		throw new BankingException("You Enter wrong Account Number...............");
	}
		
	
	//validate account balance gretater than 5000
	public static void validateAccountbalance(BankAccount acct, double amount) throws BankingException 
	{
		if(acct.getBalance()-amount<=MIN_BAL)
			throw new BankingException("You Have insuffucient balance for withdrawal...........");
	}

	//close the Bank account by account number
	public static int closeBankAccount(BankAccount[] accounts, int acctNo) throws BankingException 
	{
		BankAccount acct=new BankAccount(acctNo);
		int i=0;
		for(BankAccount ba:accounts)
		{
			if( ba != null && ba.equals(acct))
			{
				accounts[i]=null;
				System.out.println("The account close succefully........");
				return 1;
			}
			i++;
		}
		throw new BankingException("You Enter wrong Account Number...............");
		
	}

}
