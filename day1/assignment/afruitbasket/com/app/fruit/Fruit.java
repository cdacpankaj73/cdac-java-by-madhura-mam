package madhuramam.day1.assignment.afruitbasket.com.app.fruit;

public class Fruit 
{
	private String name;
	String color;
	private double weight;
	private Boolean fresh;
	
	public Fruit()
	{
		name="NA";
		color="NA";
		weight=0.0;
		fresh=false;
	}
	
	public Fruit(String nm,String cl,Double w,Boolean f)
	{
		name=nm;
		color=cl;
		weight=w;
		fresh=f;
	}
	
	public String taste()
	{
		return "The fruit has no specific taste.....";
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setStale()
	{
		this.fresh=false;
	}
	
	public String getAlldata()
	{
		return name+"\t "+color+"\t "+weight+"\t";
			
	}
	@Override
	public String toString()
	{
		return "\nFruit details is:\n name\t color\t weight\t fresh\n "+name+"\t "+color+"\t "+weight+"\t "+fresh;
	}

}
