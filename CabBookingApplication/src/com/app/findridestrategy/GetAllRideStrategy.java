package com.app.findridestrategy;

import java.util.ArrayList;

import com.app.constants.Constants;
import com.app.person.Driver;
import com.app.util.Position;
import com.app.util.Status;

public class GetAllRideStrategy implements FindRideStrategy{

	/*
	 * Function to return all Available drivers
	 */
	@Override
	public ArrayList<Driver> find_ride(ArrayList<Driver> drivers, 
			Position source, Position destination) {
		
		ArrayList<Driver> availableDrivers = new ArrayList<>();
		
		for(Driver driver: drivers) {	
			// driver is available and
			// driver distance is less than or equal to 5 units
			if(driver.getStatus() == Status.AVAILABLE 
					&& getDistance(source, driver.currentPosition) <= Constants.MINIMUM_UNIT_DISTANCE) {
				availableDrivers.add(driver);
			}			
		}
		
		return availableDrivers;
	}
	
	
	/*
	 * Function to calculate distance between user and driver
	 * Finding distance based on matrix row and column distance 
	 * (only 4 directions upward, downward, left, right)
	 */
	public int getDistance(Position userPosition, Position driverPosition) {
		return Math.abs(userPosition.getX() - driverPosition.getX()) + 
				Math.abs(userPosition.getY() - driverPosition.getY());
	}

}
