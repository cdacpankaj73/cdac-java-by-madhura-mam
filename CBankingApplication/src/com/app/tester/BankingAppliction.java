package com.app.tester;

import java.util.Scanner;

import com.app.entity.BankAccount;
import com.app.utils.BankingUtils;
import com.app.validation.BankingValidations;

public class BankingAppliction
{
	public static void main(String args[])
	{
		System.out.println("-------------Welcome to on Pankaj Banking appliction---------------------");
		
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("How many maximum account you want to allow to open:");
			int size=sc.nextInt();
			BankAccount accounts[]=new BankAccount[size];
			int ch,counter=0;
			do
			{
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("\n 1.Open Bank Account \n 2.Deposit \n 3.Withdraw \n 4.Fund Transfer \n 5.Display Account \n 6.close Account \n 7.exit ");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("Enter your choice:");
				ch=sc.nextInt();
				
				try
				{
					switch(ch)
					{
					case 1:
						if(counter==size)
						{
							System.out.println("The Account opening Still Close......");
						}
						else
						{
							System.out.println("Enter the bank Account Opening details:");
							
							System.out.println("Account Number:");
							int acctNo=sc.nextInt();
							
							System.out.println("First Name:");
							String firstName=sc.next();
							
							System.out.println("Last name");
							String lastName=sc.next();
							
							System.out.println("Account type");
							String acType=sc.next();
							
							System.out.println("Enter dob (yyyy-mm-dd)");
							String dob=sc.next();
							
							System.out.println("Enter Account creation date(yyyy-mm-dd):");
							String creationDate=sc.next();
							
							System.out.println("Enter Account Opening Balance");
							double balance=sc.nextDouble();
							
							BankAccount Acct=BankingUtils.validateAccountOpenDetails(accounts,acctNo,firstName,lastName,acType,dob,creationDate,balance);
							accounts[counter++]=Acct;
							System.out.println("Account created succefully..................");
						}
								
						break;
					case 2:
						System.out.println("Enter your Account Number:");
						int acctNo=sc.nextInt();
						
						System.out.println("Enter the Ammount you want to deposit:");
						double amount=sc.nextDouble();
						
						BankingUtils.depositeAmount(accounts,acctNo,amount);
						break;
					case 3:
						System.out.println("Enter your Account Number:");
						acctNo=sc.nextInt();
						
						System.out.println("Enter the Ammount you want to withdraw:");
						amount=sc.nextDouble();
						
						BankingUtils.withdrawAmount(accounts,acctNo,amount);
						break;
					case 4:
						System.out.println("Enter Source Account Number:");
						int sAcctNo=sc.nextInt();
						
						System.out.println("Enter Destination Account Number:");
						int dAcctNo=sc.nextInt();
						
						System.out.println("Enter the Ammount you want to transfer withdraw:");
						amount=sc.nextDouble();
						
						BankingUtils.fundTransfer(accounts,sAcctNo,dAcctNo,amount);
						break;
					case 5:
						if(counter==0)
						{
							System.out.println("No Account Created Yet......");
						}
						else
						{
							System.out.println("All Accounts Details Are:");
							for(BankAccount ba:accounts)
							{
								if(ba!=null)
									System.out.println(ba);
							}
						}
						break;
					case 6:
						System.out.println("Enter your Account Number to close Account:");
						acctNo=sc.nextInt();
						BankingValidations.closeBankAccount(accounts,acctNo);
						break;
					case 7:
						System.out.println("Thank you..............Visit again................");
						break;
					default:
						System.out.println("You Enter the wrong choice select again...........");
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
