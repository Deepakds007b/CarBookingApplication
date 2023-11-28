package com.app.demo;

import java.util.ArrayList;

import com.app.manager.AppManager;
import com.app.person.Driver;
import com.app.person.User;
import com.app.util.Gender;
import com.app.util.Position;

public class UseCase3 {

	public static void main(String[] args) {
		
		AppManager appManager = new AppManager();
		
		User Abhishek = new User("Abhishek", 26, Gender.MALE);
		User Rahul = new User("Rahul", 29, Gender.MALE);
		User Nandini = new User("Nandini", 22, Gender.FEMALE);
		
		Driver driver1 = new Driver("Driver1", 22, Gender.MALE, 
				"Swift", "KA-01-12345", new Position(10, 1));
		Driver driver2 = new Driver("Driver2", 22, Gender.MALE, 
				"Swift", "KA-01-12345", new Position(5, 0));
		Driver driver3 = new Driver("Driver3", 22, Gender.MALE, 
				"Swift", "KA-01-12345", new Position(5, 3));
		
		appManager.add_user(Abhishek);
		appManager.add_user(Rahul);
		appManager.add_user(Nandini);
		
		appManager.add_driver(driver1);
		appManager.add_driver(driver2);
		appManager.add_driver(driver3);
		
		ArrayList<Driver> availableDrivers = 
				appManager.find_ride(Nandini, new Position(5, 0), new Position(1, 0));
		
		String userMessage = appManager.checkAvailableRides(Nandini, availableDrivers);
		System.out.println(userMessage);

		availableDrivers = 
				appManager.find_ride(Rahul, new Position(5, 0), new Position(1, 0));
		
		userMessage = appManager.checkAvailableRides(Rahul, availableDrivers);
		System.out.println(userMessage);
		
	}

}
