package com.app.manager;

import java.util.ArrayList;

import com.app.person.Driver;
import com.app.util.Position;

public class DriverManager {
	
	ArrayList<Driver> drivers;
	
	public DriverManager() {
		drivers = new ArrayList<>();
	}

	public void add(Driver driver) {
		drivers.add(driver);		
	}

	public ArrayList<Driver> getAllDrivers() {
		return drivers;
	}

}
