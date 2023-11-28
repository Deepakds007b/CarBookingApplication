package com.app.findridestrategy;

import java.util.ArrayList;

import com.app.person.Driver;
import com.app.util.Position;

public interface FindRideStrategy {

	public ArrayList<Driver> find_ride(ArrayList<Driver> drivers, Position source, Position destination);
	
}
