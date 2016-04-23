/*
 * Class name: Manager.java
 * Purpose of class: This class is responsible for defines the attributes of a 
 * manager.
 * Copyright: This software follows GPL license.
 */

package model;

public class Manager {
	private String managerUsername;
	private String managerPassword;
	
	// this method is an empty constructor method
	public Manager() {
		
	}
	
	// this method is the constructor method of the class.
	public Manager(String managerUsername, String managerPassword) {
		this.managerUsername = managerUsername;
		this.managerPassword = managerPassword;
	}

	// this method is create to verify the manager user name.
	public String getManagerUsername() {
		return managerUsername;
	}
	
	// this method is create to modify the manager user name.
	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	// this method is create to verify the manager password.
	public String getManagerPassword() {
		return managerPassword;
	}

	// this method is create to modify the manager password.
	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	
	

}
