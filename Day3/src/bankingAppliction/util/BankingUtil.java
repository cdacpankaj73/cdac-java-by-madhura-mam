package bankingAppliction.util;

import java.time.LocalDate;
import java.util.Scanner;

import bankingAppliction.app.AcType;
import bankingAppliction.app.BankAccount;
import bankingAppliction.custom_exceptions.BakingException;
import bankingAppliction.valid.BankValid;

public class BankingUtil 
{
	static Scanner sc=new Scanner(System.in);
	
	//1.open new account
	public static int openAcu(BankAccount[] bac, int counter) 
	{
		try
		{
			System.out.println("Enter Your Details for opening Bank Account:");
		
			//get account number
			System.out.print("Account No:");
			int acctNo=sc.nextInt();
			//validate account number
			if(BankValid.validAccountNo(acctNo,bac,counter))
			{
				throw new BakingException("For Account Opening need minimum 5000 Account opening balance.............so terminated AC opening process..........");
			}
			
			//get first name
			System.out.print("First name:");
			String firstName=sc.next();
			
			//get last name
			System.out.print("Last name:");
			String lastName=sc.next();
			
			//get account type
			System.out.print("Available Account type are: SAVINGS, CURRENT, FD, LOAN, DMAT, NRE.");
			System.out.print("Account Type:");
			String at=sc.next();
			//validate account type
			if(BankValid.validAccountType(at.toUpperCase()))
			{
				throw new BakingException("You have only this Account Type.............so terminated AC opening process..........");
			}
			AcType acType=AcType.valueOf(at.toUpperCase());
			
			//get dob
			System.out.print("Enter DOB ('YYYY-MM-DD'):");
			String bd=sc.next();
			LocalDate dob=LocalDate.parse(bd);
			//check customer not minor
			if(BankValid.validCustomerAge(dob))
			{
				throw new BakingException("Age must be greater than 18.............so terminated AC opening process..........");
			}
			
			//get account opening date
			System.out.print("Enter Account Opening date ('YYYY-MM-DD'):");
			String od=sc.next();
			LocalDate cd=LocalDate.parse(od);
			//validate cureent finatial year
			if(BankValid.validCurrentYear(cd))
			{
				throw new BakingException("Use current year for opening.............so terminated AC opening process..........");
			}
			
			//get bance
			System.out.print("Enter Account Opening balance:");
			double balance=sc.nextDouble();
			//validate balance
			if(BankValid.validAccountBalance(balance))
			{
				throw new BakingException("For Account Opening need minimum 5000 Account opening balance.............so terminated AC opening process..........");
			}
			
			//if all done create account
			bac[counter]=new BankAccount(acctNo,firstName,lastName,acType,dob,cd,balance);
			System.out.println("Account Open Successfully.............welcome to pankaj bank.....");
			
			return ++counter;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return counter;
		}
	}

	// 2.deposit amount
	public static void depositu(BankAccount[] bac, int counter)  
	{
		try
		{
			System.out.println("Enter your Account Number:");
			int acno=sc.nextInt();
			//check this account number has account or not
			int c=BankValid.validAccountNumber(acno,bac,counter);
			if(c==-1)
			{
				throw new BakingException("You Enter wrong Account Number...............");
			}
			else
			{
				System.out.println("Enter the Ammount you want to deposit:");
				double am=sc.nextDouble();
			
				double fbl=bac[c].getBalance()+am;
				bac[c].setBalance(fbl);
				System.out.println("Ammount Deposite Successfully...............");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	//3.withdraw amount from account
	public static void withdrawu(BankAccount[] bac, int counter)
	{
		try
		{
			System.out.println("Enter your Account Number:");
			int acno=sc.nextInt();
			//check this account number has account or not
			int c=BankValid.validAccountNumber(acno,bac,counter);
			
			if(c==-1)
			{
				throw new BakingException("You Enter wrong Account Number...............");
			}
			else
			{
				System.out.println("Enter the Ammount you want to withdraw:");
				double am=sc.nextDouble();
				
				//check account have suffient money to withdraw
				if(BankValid.validForWithdraw(c,bac,am))
				{
					double fbl=bac[c].getBalance()-am;
					bac[c].setBalance(fbl);
					System.out.println("Ammount Withdraw Successfully...............");
				}
				else
				{
					throw new BakingException("You Have insuffucient balance for withdrawal...........");
				}	
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//4.transfer fund
	public static void fundTransferu(BankAccount[] bac, int counter) 
	{
		try
		{
			System.out.println("Enter Source Account Number:");
			int sacno=sc.nextInt();
			//check this account number has account or not
			int si=BankValid.validAccountNumber(sacno,bac,counter);
			
			if(si==-1)
			{
				throw new BakingException("You Enter wrong Source Account Number...............");
			}
			else
			{
				System.out.println("Enter Destination Account Number:");
				int dacno=sc.nextInt();
				//check this account number has account or not
				int di=BankValid.validAccountNumber(dacno,bac,counter);
				if(di==-1)
				{
					throw new BakingException("You Enter wrong Destination Account Number...............");
				}
				else
				{
					System.out.println("Enter amount to transfer:");
					double am=sc.nextInt();
					
					//check account contain sufficient balance or not
					if(BankValid.validForWithdraw(si,bac,am))
					{
						double sbl=bac[si].getBalance()-am;
						bac[si].setBalance(sbl);
						
						double dbl=bac[di].getBalance()+am;
						bac[di].setBalance(dbl);
						System.out.println("Fund Transfer Successfully...............");
					}
					else
					{
						throw new BakingException("You Have insuffucient balance for withdrawal...........");
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	//5.display all account details
	public static void displayAll(BankAccount[] bac, int counter)
	{
		System.out.println("All Account Details Are:");
		
		for(int i=0;i<counter;i++)
		{
			System.out.println("\nAccount "+i+1+":");
			if(bac[i]==null)
			{
				System.out.println(i+1+". Account Closed........");
			}
			else
			{
				System.out.println(bac[i]);
			}
		}
		
	}
	
	//6.close the specific account
	public static void closeAc(BankAccount[] bac, int counter)
	{
		try
		{
			System.out.println("Enter your Account Number:");
			int acno=sc.nextInt();
			int c=BankValid.validAccountNumber(acno,bac,counter);
			
			if(c==-1)
			{
				throw new BakingException("You Enter wrong Account Number...............");
			}
			else
			{
				bac[c]=null;
				System.out.println("Your Account Close Successfully...............");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
