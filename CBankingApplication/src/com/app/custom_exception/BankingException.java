package com.app.custom_exception;

public class BankingException extends Exception
{
	public BankingException(String message)
	{
		super(message);
	}

}
