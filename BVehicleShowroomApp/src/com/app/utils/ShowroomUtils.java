package com.app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.custom_exception.ShowroomAppException;
import com.app.entity.Color;
import com.app.entity.Vehicle;
import com.app.validations.ShowroomValidation;

public class ShowroomUtils 
{
	public static final Double POLLUTION_PER_KM=0.20;

	public static int AddVehicle(Vehicle[] stocks, int counter, String chasisNo, String color, double price, String manufactureDate, String insuranceExpDate, double pollutionLevel) throws ParseException, ShowroomAppException
	{
		ShowroomValidation.ValidateVehicleChasisNo(chasisNo,stocks);
		Color vehicleColor=ShowroomValidation.validateVehicleColor(color);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date manDate=formatter.parse(manufactureDate);
		Date insDate=formatter.parse(insuranceExpDate);
		ShowroomValidation.validateVehicleDate(manDate,insDate);
		ShowroomValidation.validatePollutionLevel(pollutionLevel);
		stocks[counter]=new Vehicle(chasisNo,vehicleColor,price,manDate,insDate,pollutionLevel);
		System.out.println("Vehicle added successfully to showroom.............");
		return ++counter;
	}


	public static void validatePollutionLevelByKm(double km) throws ShowroomAppException 
	{
		double pollutionLevel=km*POLLUTION_PER_KM;
		ShowroomValidation.validatePollutionLevel(pollutionLevel);
	}

}
