package com.validateSpeed.validations;

import com.validateSpeed.custom_exception.SpeedOutOfRangeException;

public class SpeedValidation 
{
	public static final int MAX_SPEED;
	public static final int MIN_SPEED;;
	static
	{
		MAX_SPEED=80;
		MIN_SPEED=40;
	}

	public static void validateSpeed(int speed) throws SpeedOutOfRangeException 
	{
		if(speed>MAX_SPEED)
		{
			throw new SpeedOutOfRangeException("Your current speed is is very high.........");
		}
		if(speed<MIN_SPEED)
		{
			throw new SpeedOutOfRangeException("Your current speed is is very Slow.........");
		}
		System.out.println("Your Speed in limit.............");
	}


}
