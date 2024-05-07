package com.app.validations;

import java.util.Date;

import com.app.custom_exception.ShowroomAppException;
import com.app.entity.Color;
import com.app.entity.Vehicle;

public class ShowroomValidation 
{

	public static Color validateVehicleColor(String color) 
	{
		
		return Color.valueOf(color.toUpperCase());
	}

	public static void validateVehicleDate(Date manDate, Date insDate) throws ShowroomAppException 
	{
		if(manDate.after(insDate))
			throw new ShowroomAppException("The insurance Expire date must be after manufacture date...............");
				
	}

	public static void validatePollutionLevel(double pollutionLevel) throws ShowroomAppException 
	{
	
		if(pollutionLevel>20)
			throw new ShowroomAppException("Your vahicle Is not valid because of pollution level is high...............");
		
		
	}

	public static void ValidateVehicleChasisNo(String chasisNo, Vehicle[] stocks) throws ShowroomAppException 
	{
		Vehicle vehicle=new Vehicle(chasisNo);
		for(Vehicle v:stocks)
		{
			if(v!=null && v.equals(vehicle))
				throw new ShowroomAppException("The Chasis Number Already taken try another unique number...............");
		}
		
	}

}
