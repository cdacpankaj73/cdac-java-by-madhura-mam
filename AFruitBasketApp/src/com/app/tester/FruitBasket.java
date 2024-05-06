package com.app.tester;

import static com.app.utils.FruitUtil.*;
import java.util.Scanner;
import com.app.fruits.Fruit;

public class FruitBasket {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------welcome to on Pankaj Fruit basket Appliction-----------");

		System.out.println("How many fruit you want to add in basket:");
		int size = sc.nextInt();
		Fruit fruitBasket[] = new Fruit[size];

		int ch, counter = 0;
		do {

			System.out.println(
					"\n1.Add fruit \n2.Display fruit name \n3.Display name,color,weight,taste \n4.Mark fruit as Stale \n5.Mark all sour fruit as Stale \n6.invoke special functionality \n7.exit ");
			System.out.println("Enter your choice:");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				if (counter == size)
				{
					System.out.println("The fruit Basket is full......");
				} else 
				{
					int fruitChoice;
					System.out.println(".....select your fruit 1.Apple 2.Mango 3.Orange ");
					System.out.println("Enter your choice:");
					fruitChoice = sc.nextInt();
					
					System.out.println("\nEnter Fruit name:");
					String name = sc.next();

					System.out.println("Enter Fruit Color:");
					String color = sc.next();

					System.out.println("Enter Fruit Weight:");
					double weight = sc.nextDouble();

					Boolean fresh;
					System.out.println("For 1.Fresh 2.Stale \n Enter your choice:");
					int freshChoice = sc.nextInt();
					if (freshChoice == 1) {
						fresh = true;
					} else {
						fresh = false;
					}
					
					if(fresh)
					{
						System.out.println(fresh);
						counter = addFruit(fruitBasket,counter,fruitChoice,name,color,weight,fresh);		
					}
					else
					{
						System.out.println("The Fruit basket added only fresh fruit.............");
					}
					
				}

				break;
			case 2:
				getFruitByName(fruitBasket,counter);
				break;
			case 3:
				getFruitData(fruitBasket, counter);
				break;
			case 4:
				System.out.println("\nEnter the fruit index to mark as stale:");
				int index = sc.nextInt();
				setFruitStale(fruitBasket, counter,index);
				break;
			case 5:
				setSourFruitStale(fruitBasket, counter);
				break;
			case 6:
				getAllFruit(fruitBasket, counter);
				break;
			case 7:
				System.out.println("Thank you..............Visit again................");
				break;
			default:
				System.out.println("You Enter the wrong choice select again...........");
			}
		} while (ch != 7);

	}
}