package com.cms.utils;

import java.util.List;

import com.cms.custom_exception.CMSExceptions;
import com.cms.entity.Customer;

public class CMSutils
{

	public static Customer authenticateCustomer(String email, String password, List<Customer> custList) throws CMSExceptions 
	{
		int index = custList.indexOf(new Customer(email));
		
		if (index == -1)
			throw new CMSExceptions("You Enter the Wrong email.......");
		
		Customer cust= custList.get(index);
		
		if (cust.getPassword().equals(password))
			return cust;
		
		throw new CMSExceptions("You Enter the wrong password..........");
	}
	
	public static String unSuscribeCustomer(String email, List<Customer> custList) throws CMSExceptions
	{
		
		int index = custList.indexOf(new Customer(email));
		
		if (index == -1)
			throw new CMSExceptions("You Enter Invalid email...............");
		
		return "Unsubscribe Customer details is" + custList.remove(index);
	}

	


}
