package com.app.person;

import com.app.util.Gender;

public class User extends Person {
	
	Driver currentDriverAssigned;

	public User(String name, int age, Gender gender) {
		super(name, age, gender);
	}

	public Driver getCurrentDriverAssigned() {
		return currentDriverAssigned;
	}

	public void setCurrentDriverAssigned(Driver currentDriverAssigned) {
		this.currentDriverAssigned = currentDriverAssigned;
	}	
}
