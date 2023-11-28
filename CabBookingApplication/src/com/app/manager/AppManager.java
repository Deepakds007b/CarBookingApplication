package com.app.manager;

import java.util.ArrayList;
import java.util.Scanner;

import com.app.findridestrategy.FindRideStrategy;
import com.app.findridestrategy.GetAllRideStrategy;
import com.app.person.Driver;
import com.app.person.User;
import com.app.util.Position;
import com.app.util.Status;

public class AppManager {

	UserManager userManager;
	DriverManager driverManager;
	FindRideManager findRideManager;
	
	public AppManager() {
		userManager = new UserManager();
		driverManager = new DriverManager();
		findRideManager = new FindRideManager();
	}
	
	// Function to add user
	public void add_user(User user) {
		userManager.add(user);
	}
	
	// Function to add driver
	public void add_driver(Driver driver) {
		driverManager.add(driver);
	}
	
	/*
	 * Function to to find all available rides.
	 */
	public ArrayList<Driver> find_ride(User user, Position source, Position destination) {	
		
		if(user.getCurrentDriverAssigned() != null) {			
			return null;
		}
		
		return findRideManager.findRide(driverManager.getAllDrivers(), source, 
				destination, new GetAllRideStrategy());
	}	
	
	/*
	 * Function to to find rides according to specified strategy
	 */
	public ArrayList<Driver> find_ride_with_strategy(User user, 
			Position source, Position destination, FindRideStrategy findRideStrategy) {
		return findRideManager.findRide(driverManager.getAllDrivers(), 
				source, destination, findRideStrategy);
	}
	
	
	
	public String show_available_driver(User user, ArrayList<Driver> availableDrivers) {
		
		String userMessage = "";
		int totalDrivers = availableDrivers.size();
		
		System.out.println(user.getName() + " Please choose your ride.");
		
		for(int index = 0; index < totalDrivers; index++) {
			System.out.println("Enter " + (index + 1) 
					+ " for driver " + availableDrivers.get(index).getName());
		}
		
		boolean takeUserInput = true;
		
		Scanner scn = new Scanner(System.in);
		
		while(takeUserInput) {
			try {
				
				int driverNumber = scn.nextInt();
				
				if(driverNumber <= totalDrivers) {
					Driver chosenDriver = availableDrivers.get(driverNumber - 1);
					userMessage = "Driver " + chosenDriver.getName() 
					+ " has been assigned to " + user.getName();
					
					choose_ride(user, chosenDriver);
					takeUserInput = false;
				} else {
					System.out.println("Invalid Input");
				}
			} catch(Exception e) {
				System.out.println("Ex Invalid Input");
			}
		}
		
		return userMessage;		
	}
	
	public void choose_ride(User user, Driver driver) {
		user.setCurrentDriverAssigned(driver);
		driver.setCurrentUserAssigned(user);		
		driver.setStatus(Status.OCCUPIED);
	}

	public String checkAvailableRides(User user,ArrayList<Driver> availableDrivers) {
		
		if(null == availableDrivers) {
			return "Driver is already assigned to " + user.getName();
		} else if(availableDrivers.isEmpty()) {
			return "No ride Found";
		}
		
		return show_available_driver(user, availableDrivers);	
	}
	
}
