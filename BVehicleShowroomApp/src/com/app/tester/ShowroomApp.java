package com.app.tester;

import java.util.Date;
import java.util.Scanner;

import com.app.entity.Color;
import com.app.entity.Vehicle;
import com.app.utils.ShowroomUtils;
import com.app.validations.ShowroomValidation;

public class ShowroomApp {
	public static void main(String args[]) 
	{
		int ch,counter=0;

		try (Scanner  sc= new Scanner(System.in)) 
		{
			System.out.println("--------------welcome to on Pankaj Vehicle Showroom Appliction-----------");
			System.out.println("How many Vehicle you want add in showroom:");
			int size=sc.nextInt();
			Vehicle stocks[]=new Vehicle[size];
			do 
			{
				System.out.println("-------------------------------------------------------------");
				System.out.println(" 1.Add Vehicle \n 2.Drive Vehicle \n 3.Exit");
				System.out.println("-------------------------------------------------------------");
				System.out.println("Enter your choice:");
				ch=sc.nextInt();
			
				try 
				{
					switch(ch)
					{
					case 1:
						if(counter==size)
						{
							System.out.println("Showroom Stock is full..............");
						}
						else
						{
							System.out.println("Enter the vehicle details:");
							
							System.out.println("ChasisNo:");
							String chasisNo=sc.next();
							
							System.out.println("Availbale color:WHITE , SILVER , BLACK , RED , BLUE");
							System.out.println("Color:");
							String color=sc.next();
							
							System.out.println("Price:");
							double price=sc.nextDouble(); 
							
							System.out.println("Manufacture Date (dd-MM-yyyy)");
							String manufactureDate=sc.next();
							
							System.out.println("InsuranceExp Date  (dd-MM-yyyy)");
							String insuranceExpDate=sc.next();
							
							System.out.println("Pollution Level");
							double pollutionLevel=sc.nextDouble();
							
							counter=ShowroomUtils.AddVehicle(stocks,counter,chasisNo,color,price,manufactureDate,insuranceExpDate,pollutionLevel);
						}
						break;
					case 2:
						System.out.println("Enter the Kilometer of vehicle you  drived:");
						double km=sc.nextDouble();
						ShowroomUtils.validatePollutionLevelByKm(km);
						break;
					case 3:
						System.out.println("Thank you.............visit again.............");
						break;
					default:
						System.out.println("You enter the wrong choice.................");
					}
					
				} 
				catch (Exception e) 
				{
					System.out.println(e.getMessage());

				}

			} while (ch != 5);

		}
	}
}
