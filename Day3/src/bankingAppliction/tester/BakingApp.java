package bankingAppliction.tester;

import java.util.Scanner;

import bankingAppliction.app.BankAccount;
import bankingAppliction.util.BankingUtil;

public class BakingApp 
{
	public static void main(String args[])
	{
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("--------------welcome to on Pankaj Banking Appliction-----------");
			
			System.out.println("How many Account you want to Open:");
			int size=sc.nextInt();
			BankAccount bac[]=new BankAccount [size];
			
			int ch,counter=0;
			do
			{
				
				System.out.println("\n1.Open Bank Account \n2.Deposit \n3.Withdraw \n4.Fund Transfer \n5.Display Account \n6.close Account \n7.exit ");
				System.out.println("Enter your choice:");
				ch=sc.nextInt();
				
				switch(ch)
				{
				case 1:
					if(counter==size)
					{
						System.out.println("The Account opening Still Close......");
					}
					else
					{
						counter=BankingUtil.openAcu(bac,counter);	
					}
							
					break;
				case 2:
					BankingUtil.depositu(bac,counter);
					break;
				case 3:
					BankingUtil.withdrawu(bac,counter);
					break;
				case 4:
					BankingUtil.fundTransferu(bac,counter);
					break;
				case 5:
					BankingUtil.displayAll(bac,counter);
					break;
				case 6:
					BankingUtil.closeAc(bac,counter);
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

}
