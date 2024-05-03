package com.cms.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.cms.entity.Customer;
import com.cms.entity.ServicePlan;
import com.cms.utils.CMSValidation;
import com.cms.utils.CMSutils;



public class CMSAppliction 
{

	public static void main(String[] args) 
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("-----------------Welcome to on Customer Mangement System----------");
		
			List<Customer> custList=new ArrayList<>();
			Customer cd=new Customer("prashant","dukare","prashantdukare73@gmail.com ","Prashant@73",1000,LocalDate.parse("2002-12-29"),ServicePlan.valueOf("silver".toUpperCase())); 
			custList.add(cd);
			cd=new Customer("pankaj","dukare","pankajdukare73@gmail.com","Pankaj@73",2000,LocalDate.parse("2000-06-02"),ServicePlan.valueOf("gold".toUpperCase()));
			custList.add(cd);
			int ch;
			do
			{
				System.out.println("-----------------Menu-------------------------");
				System.out.println(" 1.Sign Up \n 2.Sign \n 3.Change Password \n 4.Unsuscribe Customer \n 5.Display All Customer \n 6.Sorting \n 7.Exit ");
				System.out.println("----------------------------------------------");
				System.out.print("Enter Your Choice:");
				ch=sc.nextInt();
				try 
				{
					switch(ch)
					{
					case 1:
						System.out.println("Service plan and cost -->SILVER:1000  GOLD:2000   DIAMOND:5000  PLATINUM:10000");
						System.out.println("Enter the Customer Details to Sign Up:");
						System.out.println(" firstName \t LastName \t Email \t Password \t Registration Amount \t Date of Birth \t Service Plan");
						Customer cust=CMSValidation.validateCustomerInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),custList);
						System.out.println("Customer Added Successfully...\n"+cust);
						break;
					case 2:
						System.out.println("Enter the Email and Password For Login:");
						CMSutils.authenticateCustomer(sc.next(),sc.next(),custList);
						System.out.println("the customer login succefull........");
						break;
					case 3:
						System.out.println("Enter the email oldpassword and new password for change password");
						Customer authCustomer=CMSutils.authenticateCustomer(sc.next(),sc.next(),custList);
						authCustomer.setPassword(sc.next());
						System.out.println("Succefully change password........");
						break;
					case 4:
						System.out.println("Enter Email to unsucribe plan");
						System.out.println(CMSutils.unSuscribeCustomer(sc.next(),custList));
						break;
					case 5:
						System.out.println("Customer are:");
						for(Customer c : custList)
							System.out.println(c);
						//System.out.println(custList);
						break;
					case 6:
						System.out.println("sorting");
						Collections.sort(custList);
						break;
					case 7:
						System.out.println("Thank you................visit again.................");
						break;
					default:
						System.out.println("You Enter the wrong Choice");
					}
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			
			}while(ch!=7);
		}
	}
}
