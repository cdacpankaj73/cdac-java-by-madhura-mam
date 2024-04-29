package afruitbasket.com.app.fruit;

public class Apple extends Fruit
{
	public Apple()
	{
		super();
	}
	
	public Apple(String nm,String cl,Double w,Boolean f)
	{
		super(nm,cl,w,f);
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
