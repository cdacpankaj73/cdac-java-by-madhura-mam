package bankingAppliction.valid;

import java.time.LocalDate;
import java.time.Period;

import bankingAppliction.app.AcType;
import bankingAppliction.app.BankAccount;
import bankingAppliction.custom_exceptions.BakingException;

public class BankValid 
{
	//check the enter account number is valid or not
	public static int validAccountNumber(int acno, BankAccount[] bac,int counter) 
	{
		int flag=1,i=-1;
		for(int j=0;j<counter;j++)
		{
			i++;
			if(bac[j]==null)
			{
				continue;
			}
			if(bac[j].getAcctNo()==acno)
			{
				flag=0;
				break;	
			}
		}
		if(flag==0)
		{
			return i;
		}
		else
		{
			return -1;
		}
	}
	
	// check account balance for withdraw money
	public static boolean validForWithdraw(int c, BankAccount[] bac,Double am) 
	{
		if((bac[c].getBalance()-5000)>=am)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//check acccount number is already taken or not
	public static boolean validAccountNo(int acno, BankAccount[] bac, int counter) 
	{
		int flag=1;
		for(int i=0;i<counter;i++)
		{
			if(bac[i]==null)
			{
				continue;
			}
			if(bac[i].getAcctNo()==acno)
			{
				flag=0;
				break;	
			}
		}
		if(flag==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//validate enter account type is present or not in enum
	public static boolean validAccountType(String at) 
	{
		int flag=0;
		for(AcType c : AcType.values())
		{
			
		      if(c.name().equals(at))
		      {
		    	 flag=1;
		    	 break;
		      }
		}
		if(flag==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//validate customer age
	public static boolean validCustomerAge(LocalDate dob) 
	{
		LocalDate td=LocalDate.now();
		if((Period.between(dob,td).getYears())>18 )
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	//validate current finatial year 
	public static boolean validCurrentYear(LocalDate cd) 
	{
		LocalDate td=LocalDate.now();
		if(td.getYear()==cd.getYear())
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	//validate account balace
	public static boolean validAccountBalance(double balance) 
	{
		if(balance<5000)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}


	

	
}
