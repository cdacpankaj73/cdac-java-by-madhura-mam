package afruitbasket.com.app.util;

import java.util.Scanner;

import afruitbasket.com.app.fruit.*;

public class FruitUtil 
{
	static Scanner sc=new Scanner(System.in);
	//1.Add fruit
	public static int addFruit(Fruit f[],int i)
	{
		int fch;
		System.out.println(".....select your fruit 1.Apple 2.Mango 3.Orange ");
		System.out.println("Enter your choice:");
		
		fch=sc.nextInt();
		
		switch(fch)
		{
			case 1:
				System.out.println("\nEnter Fruit name:");
				String name=sc.next();
				
				System.out.println("Enter Fruit Color:");
				String color=sc.next();
				
				System.out.println("Enter Fruit Weight:");
				double weight=sc.nextDouble();
				
				Boolean fresh;
				System.out.println("For 1.Fresh 2.Stale \n Enter your choice:");
				int ch=sc.nextInt();
				if(ch==1)
				{
					fresh=true;
				}
				else
				{
					fresh=false;
				}
				f[i]=new Apple(name,color,weight,fresh);
				System.out.println("Apple Added Successfully...................");
				i++;
				break;
				
			case 2:
				System.out.println("Enter Fruit name:");
				name=sc.next();
				
				System.out.println("Enter Fruit Color:");
				color=sc.next();
				
				System.out.println("Enter Fruit Weight:");
				weight=sc.nextDouble();
				
				
				System.out.println("1.Fresh 2.Stale \n Enter your choice:");
				ch=sc.nextInt();
				if(ch==1)
				{
					fresh=true;
				}
				else
				{
					fresh=false;
				}
				f[i]=new Mango(name,color,weight,fresh);
				System.out.println("Mango Added Successfully...................");
				i++;
				break;
				
			case 3:
				System.out.println("Enter Fruit name:");
				name=sc.next();
				
				System.out.println("Enter Fruit Color:");
				color=sc.next();
				
				System.out.println("Enter Fruit Weight:");
				weight=sc.nextDouble();
				
				
				System.out.println("1.Fresh 2.Stale \n Enter your choice:");
				ch=sc.nextInt();
				if(ch==1)
				{
					fresh=true;
				}
				else
				{
					fresh=false;
				}
				f[i]=new Orange(name,color,weight,fresh);
				System.out.println("Orange Added Successfully...................");
				i++;
				break;
			default:
				System.out.println("Only three fruits are available...........");
		}
		return i;
	}

	//2.Display fruit name
	public static void getName(Fruit fb[],int c) 
	{
		if(c==0)
		{
			System.out.println("The fruit basket is Empty...........");
		}
		else
		{
			System.out.println("\nName of fruits in Basket Are:");
			for(int i=0;i<c;i++)
			{
				System.out.println((i+1)+"."+fb[i].getName());
			}
		}
	}

	//3.Display name,color,weight,taste
	public static void getData(Fruit[] fb, int c)
	{
		if(c==0)
		{
			System.out.println("The fruit basket is Empty...........");
		}
		else
		{
			System.out.println("\nFruit details Are:\n Name \t Color\t weight \t taste");
			for(int i=0;i<c;i++)
			{
				System.out.print(i+".");
				System.out.print(fb[i].getAlldata());
				System.out.print(fb[i].taste()+"\n");
			}
		}
	}

	//4.Mark fruit as Stale
	public static void setStale(Fruit[] fb, int c)
	{
		System.out.println("\nEnter the fruit index to mark as stale:");
		int index=sc.nextInt();
		if(index<c)
		{
			fb[index].setStale();
			System.out.println("Thefruit mark as stale successfully..............");
			
		}
		else {
			System.out.println("the baskert contain only "+c+" Fruit..........");
		}
		
	}

	//5.Mark all sour fruit as Stale
	public static void setSourStale(Fruit[] fb, int c) 
	{
		if(c==0)
		{
			System.out.println("The fruit basket is Empty...........");
		}
		else
		{
			for(int i=0;i<c;i++)
			{
				if(fb[i].taste().contains("sour"))
					fb[i].setStale();
			}
			System.out.println("The sour fruit mark as stale successfully..............");
		}
	}

	//6.invoke special functionality
	public static void getAll(Fruit[] fb, int c) 
	{
		if(c==0)
		{
			System.out.println("The fruit basket is Empty...........");
		}
		else
		{
			for(int i=0;i<c;i++)
			{
				System.out.println("\nFruit "+(i+1)+":");
				System.out.println(fb[i]);
				System.out.println("Taste:"+fb[i].taste());
				System.out.print("Opertion:");
				if(fb[i] instanceof Apple)
				{
					Apple a=(Apple)fb[i];
					a.jam();
					
				}
				else if(fb[i] instanceof Mango)
				{
					Mango m=(Mango)fb[i];
					m.pulp();
				}
				else
				{
					Orange o=(Orange)fb[i];
					o.juice();
				}
			}
		}
		
	}
	
	

}
