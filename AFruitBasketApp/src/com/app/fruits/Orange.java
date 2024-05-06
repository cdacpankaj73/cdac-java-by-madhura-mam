package com.app.fruits;

public class Orange extends Fruit
{
	public Orange()
	{
		super();
	}
	
	public Orange(String nm,String cl,Double w,Boolean f)
	{
		super(nm,cl,w,f);
	}
	
	@Override
	public String taste()
	{
		return "sour";
		
	}
	
	public void juice()
	{
		System.out.println("We Make a juice from Orange........");
	}

}