package madhuramam.day1.assignment.afruitbasket.com.app.tester;

import java.util.Scanner;

import madhuramam.day1.assignment.afruitbasket.com.app.fruit.Fruit;
import madhuramam.day1.assignment.afruitbasket.com.app.util.FruitUtil;

public class FruitBasket 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("--------------welcome to on Pankaj Fruit basket Appliction-----------");
		
		System.out.println("How many fruit you want to add in basket:");
		int size=sc.nextInt();
		Fruit fb[]=new Fruit[size];
		
		int ch,counter=0;
		do
		{
			
			System.out.println("\n1.Add fruit \n2.Display fruit name \n3.Display name,color,weight,taste \n4.Mark fruit as Stale \n5.Mark all sour fruit as Stale \n6.invoke special functionality \n7.exit ");
			System.out.println("Enter your choice:");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				if(counter==size)
				{
					System.out.println("The fruit Basket is full......");
				}
				else
				{
					counter=FruitUtil.addFruit(fb,counter);	
				}
						
				break;
			case 2:
				FruitUtil.getName(fb,counter);
				break;
			case 3:
				FruitUtil.getData(fb,counter);
				break;
			case 4:
				FruitUtil.setStale(fb,counter);
				break;
			case 5:
				FruitUtil.setSourStale(fb,counter);
				break;
			case 6:
				FruitUtil.getAll(fb,counter);
				break;
			case 7:
				System.out.println("Thank you..............Visit again................");
				break;
			default:
				System.out.println("You Enter the wrong choice select again...........");
			}
		}while(ch!=7);
		
	}
}
