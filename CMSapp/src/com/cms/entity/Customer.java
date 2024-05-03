package com.cms.entity;

import java.time.LocalDate;


public class Customer implements Comparable
{
	private int customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private ServicePlan plan;
	private static int idGenerator;
	
	public Customer(String firstName, String lastName, String email, String password, double regAmount,
			LocalDate dob, ServicePlan plan)
	{
	
		this.customerId =++idGenerator;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}

	public Customer(String email) 
	{
	
		this.email = email;
	}
	
	

	public int getCustomerId()
	{
		return customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public double getRegAmount()
	{
		return regAmount;
	}

	public void setRegAmount(double regAmount)
	{
		this.regAmount = regAmount;
	}

	public LocalDate getDob()
	{
		return dob;
	}

	public void setDob(LocalDate dob)
	{
		this.dob = dob;
	}

	public ServicePlan getPlan() 
	{
		return plan;
	}

	public void setPlan(ServicePlan plan)
	{
		this.plan = plan;
	}

	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof Customer)
		{
			Customer c=(Customer)obj;
			return this.email.equals(c.email);
		}
		return false;
	}
	
	@Override
	public int compareTo(Object o) 
	{
		return this.getEmail().compareTo(((Customer)o).getEmail());
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan
				+ "]";
	}

	
	

	
	
	
	
}
