package com.app.fruits;

public class Fruit 
{
	private String name;
	String color;
	private double weight;
	private boolean fresh;

	public Fruit() 
	{
		name = "NA";
		color = "NA";
		weight = 0.0;
		fresh = false;
	}

	public Fruit(String name, String color, Double weight, Boolean fresh) 
	{
		this.name = name;
		this.color = color;
		this.weight = weight;
		this.fresh = fresh;
	}

	public String taste() 
	{
		return "The fruit has no specific taste.....";
	}

	public String getName() 
	{
		return name;
	}
	
	public boolean getStale() 
	{
		return this.fresh;
	}

	public void setStale() 
	{
		this.fresh = false;
	}
	
	@Override
	public String toString()
	{
		return name + "\t " + color + "\t " + weight + "\t";
	}

}
