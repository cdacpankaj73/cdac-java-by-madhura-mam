package com.cms.entity;

public enum ServicePlan 
{
	SILVER(1000),GOLD(2000), DIAMOND(5000), PLATUNUM(10000);

	private double planCost;

	private ServicePlan(double cost) 
	{
		this.planCost = cost;
	}
	
	public double getPlanCost() {
		return planCost;
	}

}
