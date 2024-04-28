package madhuramam.day1.assignment.afruitbasket.com.app.fruit;

public class Mango extends Fruit
{
	public Mango()
	{
		super();
	}
	
	public Mango(String nm,String cl,Double w,Boolean f)
	{
		super(nm,cl,w,f);
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