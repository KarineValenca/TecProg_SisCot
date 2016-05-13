/**
 * File name: Manager.java
 * Purpose of file: This file is composed by a Manager class and methods.
 * Copyright: This software follows GPL license.
 */

package model;

/**
 * Class name: Manager
 * Purpose of class: This class is responsible for defines the attributes of a 
 * manager.
 */
public class Manager {
		
	/**
	 * Method name: Manager
	 * Purpose of method: This method is an empty constructor method
	 */
	public Manager() {
		
	}
	
	private String managerUsername;
	private String managerPassword;
	
	/**
	 * Method name: Manager
	 * Purpose of method: This method is the constructor method of the class.
	 * @param managerUsername Represents the manager user name.
	 * @param managerPassword Represents the manager password for aplication.
	 */
	public Manager(String managerUsername, String managerPassword) {
		this.managerUsername = managerUsername;
		this.managerPassword = managerPassword;
	}

	public String getManagerUsername() {
		return managerUsername;
	}
	
	public void setManagerUsername(String managerUsername) {
		this.managerUsername = managerUsername;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}
	
}
