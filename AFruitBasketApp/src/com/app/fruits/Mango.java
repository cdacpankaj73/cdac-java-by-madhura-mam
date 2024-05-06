package com.app.fruits;

public class Mango extends Fruit
{
	public Mango()
	{
		super();
	}
	
	public Mango(String name, String color, Double weight, Boolean fresh) 
	{
		super(name,color,weight,fresh);
	}
	
	@Override
	public String taste()
	{
		return "Sweet";
		
	}
	
	public void pulp()
	{
		System.out.println("We Extract a pulp from Mango........");
	}

}