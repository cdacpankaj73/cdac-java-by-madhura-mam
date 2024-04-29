package bankingAppliction.app;

import java.time.LocalDate;

public class BankAccount 
{
	private int acctNo;
	private String firstName;
	private String lastName;
	private AcType acType;
	private LocalDate dob;
	private LocalDate creationDate;
	private double balance;
	
	public BankAccount() 
	{
		acctNo=0;
		firstName="NA";
		lastName="NA";
		acType=null;
		dob=null;
		creationDate=null;
		balance=0.0;
	}

	public BankAccount(int acctNo, String firstName, String lastName, AcType acType, LocalDate dob,
			LocalDate creationDate, double balance) 
	{

		this.acctNo = acctNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.acType = acType;
		this.dob = dob;
		this.creationDate = creationDate;
		this.balance = balance;
	}
	
	

	public int getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(int acctNo) {
		this.acctNo = acctNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AcType getAcType() {
		return acType;
	}

	public void setAcType(AcType acType) {
		this.acType = acType;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "acctNo:" +acctNo+"\nfirstName:" + firstName + "\nlastName:" + lastName + "\nacType:"
				+ acType + "\ndob:" + dob + "\ncreationDate:" + creationDate + "\nbalance:" + balance;
	}


	
	
}
