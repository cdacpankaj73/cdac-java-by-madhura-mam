package com.cms.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.cms.custom_exception.CMSExceptions;
import com.cms.entity.Customer;
import com.cms.entity.ServicePlan;

public class CMSValidation 
{
	public static Customer validateCustomerInputs(String firstName, String lastName, String email, String password,
			double regAmount, String dob, String plan, List<Customer> custList) throws CMSExceptions
	{
		//validate email
		validateCustomerEmail(email,custList);
		
		//validate password
		validateCustomerPassword(password);
		
		//validate plan
		ServicePlan sPlan=validatePlanRegAmount(plan,regAmount);
		
		//validate age is greater than 18
		LocalDate date=validateCustomerAge(dob);
		
		//all done create object of customer and add in list
		Customer c=new Customer(firstName,lastName,email,password,regAmount,date,sPlan);
		custList.add(c);
		return c;
	}

	private static void validateCustomerEmail(String email, List<Customer> custList) throws CMSExceptions 
	{
		Customer c=new Customer(email);
		if(!(email.endsWith(".com") ||email.endsWith(".com")||email.endsWith(".com")))
		{
			throw new CMSExceptions("Email Must be end with .com or .org or .net ............");
		}
		if(custList.contains(c))
		{
			throw new CMSExceptions("Email is alredy present in customer list...........");
		}
		
	}
	
	private static void validateCustomerPassword(String password) throws CMSExceptions 
	{
		String regex="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})";
		if(!password.matches(regex))
		{
			throw new CMSExceptions("Please Enter Strong Password......");
		}
	}

	
	private static ServicePlan validatePlanRegAmount(String plan, double regAmount) throws CMSExceptions
	{
		try
		{
			ServicePlan sPlan=ServicePlan.valueOf(plan.toUpperCase());
			if(sPlan.getPlanCost()==regAmount)
			{
				return sPlan;
			}
			throw new CMSExceptions("the registration amount doesnot match with the chosen plan...........");
		}
		catch(Exception e)
		{
			throw new CMSExceptions("Please enter the correct plan...........");
		}
		
	}
	
	private static LocalDate validateCustomerAge(String dob) throws CMSExceptions 
	{
		LocalDate date=LocalDate.parse(dob);
		if(Period.between(date,LocalDate.now()).getYears()<18)
		{
			throw new CMSExceptions("Your age is less than 18...........");
		}
		return date;
	}
}
