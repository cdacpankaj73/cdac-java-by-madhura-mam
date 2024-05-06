package com.app.utils;

import java.util.Scanner;

import com.app.fruits.Apple;
import com.app.fruits.Fruit;
import com.app.fruits.Mango;
import com.app.fruits.Orange;

public class FruitUtil
{

	// 1.Add fruit
	public static int addFruit(Fruit[] fruitBasket, int counter, int fruitChoice, String name, String color,double weight, Boolean fresh) 
	{

		switch (fruitChoice) 
		{
		case 1:
			fruitBasket[counter] = new Apple(name, color, weight, fresh);
			System.out.println("Apple Added Successfully...................");
			counter++;
			break;
		case 2:
			fruitBasket[counter] = new Mango(name, color, weight, fresh);
			System.out.println("Mango Added Successfully...................");
			counter++;
			break;
		case 3:
			fruitBasket[counter] = new Orange(name, color, weight, fresh);
			System.out.println("Orange Added Successfully...................");
			counter++;
			break;
		default:
			System.out.println("Only three fruits are available...........");
		}
		return counter;
	}


	// 2.Display fruit name
	public static void getFruitByName(Fruit[] fruitBasket, int counter)
	{
		if (counter== 0)
		{
			System.out.println("The fruit basket is Empty...........");
		}
		else
		{
			System.out.println("\nName of fruits in Basket Are:");
			for (int i = 0; i < counter; i++)
			{
				System.out.println((i + 1) + "." + fruitBasket[i].getName());
			}
		}
	}

	// 3.Display name,color,weight,taste
	public static void getFruitData(Fruit[] fruitBasket, int counter) 
	{
		if (counter == 0) 
		{
			System.out.println("The fruit basket is Empty...........");
		} else 
		{
			System.out.println("\nFruit details Are:\n Name \t Color\t weight \t taste");
			for (int i = 0; i < counter; i++) 
			{
				System.out.print(i + ".");
				System.out.print(fruitBasket[i]);
				System.out.print(fruitBasket[i].taste() + "\n");
			}
		}
	}

	// 4.Mark fruit as Stale
	public static void setFruitStale(Fruit[] fruitBasket, int counter,int index) {
	
		if (index < counter)
		{
			fruitBasket[index].setStale();
			System.out.println("Thefruit mark as stale successfully..............");

		}
		else
		{
			System.out.println("the baskert contain only " + counter + " Fruit..........");
		}

	}

	// 5.Mark all sour fruit as Stale
	public static void setSourFruitStale(Fruit[] fruitBasket, int counter)
	{
		if (counter == 0) 
		{
			System.out.println("The fruit basket is Empty...........");
		}
		else
		{
			for (int i = 0; i < counter; i++) 
			{
				if (fruitBasket[i].taste().contains("sour"))
					fruitBasket[i].setStale();
			}
			System.out.println("The sour fruit mark as stale successfully..............");
		}
	}

	// 6.invoke special functionality
	public static void getAllFruit(Fruit[] fruitBasket, int counter) 
	{
		if (counter == 0) 
		{
			System.out.println("The fruit basket is Empty...........");
		} 
		else 
		{
			for (int i = 0; i < counter; i++)
			{
				System.out.println("\nFruit " + (i + 1) + ":");
				System.out.println("Name \t Color\t weight \t fresh");
				System.out.println(fruitBasket[i]+"\t"+fruitBasket[i].getStale());
				System.out.println("Taste:" + fruitBasket[i].taste());
				System.out.print("Opertion:");
				if (fruitBasket[i] instanceof Apple)
				{
					Apple a = (Apple) fruitBasket[i];
					a.jam();

				} 
				else if (fruitBasket[i] instanceof Mango) 
				{
					Mango m = (Mango) fruitBasket[i];
					m.pulp();
				} 
				else 
				{
					Orange o = (Orange) fruitBasket[i];
					o.juice();
				}
			}
		}

	}

}
