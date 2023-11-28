package com.app.manager;

import java.util.ArrayList;

import com.app.findridestrategy.FindRideStrategy;
import com.app.person.Driver;
import com.app.util.Position;

public class FindRideManager {

	public ArrayList<Driver> findRide(ArrayList<Driver> drivers, Position source, 
			Position destination, FindRideStrategy findRideStrategy) {
		
		return findRideStrategy.find_ride(drivers, source, destination);
	}

}
