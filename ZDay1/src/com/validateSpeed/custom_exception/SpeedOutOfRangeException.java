package com.validateSpeed.custom_exception;


public class SpeedOutOfRangeException extends Exception 
{
	public SpeedOutOfRangeException(String message)
	{
		super(message);
	}

}
