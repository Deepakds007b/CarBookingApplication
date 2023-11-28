package com.app.person;

import com.app.util.Gender;
import com.app.util.Position;
import com.app.util.Status;

public class Driver extends Person {
	
	private String carName;
	private String carNumber;
	public Position currentPosition;
	public int rating;
	public Status status = Status.AVAILABLE;
	public User currentUserAssigned;

	public Driver(String name, int age, Gender gender, 
			String carName, String carNumber, Position currentPosition) {
		super(name, age, gender);
		
		this.carName = carName;
		this.carNumber = carNumber;
		this.currentPosition = currentPosition;
	}	

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public User getCurrentUserAssigned() {
		return currentUserAssigned;
	}

	public void setCurrentUserAssigned(User currentUserAssigned) {
		this.currentUserAssigned = currentUserAssigned;
	}

	@Override
	public String toString() {
		return super.name;
	}
	
}
