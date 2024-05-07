package com.app.entity;

import java.util.Date;
import java.util.Objects;

public class Vehicle 
{
	private String chasisNo;
	private Color color;
	private double price;  
	private Date manufactureDate;
	private Date insuranceExpDate;
	private double pollutionLevel;
	
	public Vehicle(String chasisNo, Color color, double price, Date manufactureDate, Date insuranceExpDate,double pollutionLevel)
	{
		
		this.chasisNo = chasisNo;
		this.color = color;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.insuranceExpDate = insuranceExpDate;
		this.pollutionLevel = pollutionLevel;
	}
	
	public Vehicle(String chasisNo)
	{
		this.chasisNo = chasisNo;
	}
	
	

	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getInsuranceExpDate() {
		return insuranceExpDate;
	}

	public void setInsuranceExpDate(Date insuranceExpDate) {
		this.insuranceExpDate = insuranceExpDate;
	}

	public double getPollutionLevel() {
		return pollutionLevel;
	}

	public void setPollutionLevel(double pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj  instanceof Vehicle)
		{
			return this.chasisNo.equals(((Vehicle)obj).chasisNo);
		}
		return false;
	}

	@Override
	public String toString() 
	{
		return "Vehicle [chasisNo=" + chasisNo + ", color=" + color + ", price=" + price + ", manufactureDate="
				+ manufactureDate + ", insuranceExpDate=" + insuranceExpDate + ", pollutionLevel=" + pollutionLevel
				+ "]";
	}

}
