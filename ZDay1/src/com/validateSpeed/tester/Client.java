package com.validateSpeed.tester;

import java.util.Scanner;

import static com.validateSpeed.validations.SpeedValidation.*;

public class Client 
{
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter your Current Car speed:");
			int speed=sc.nextInt();
			validateSpeed(speed);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
