package com.app.fruits;

public class Apple extends Fruit
{
	public Apple()
	{
		super();
	}
	
	public Apple(String name, String color, Double weight, Boolean fresh) 
	{
		super(name,color,weight,fresh);
	}
	
	@Override
	public String taste()
	{
		return "Sweet and sour";
		
	}
	
	public void jam()
	{
		System.out.println("We create a jam from Apple........");
	}

	

}