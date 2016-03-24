package model;

public class Manager {
	private String managerUsername;
	private String managerPassword;
	
	public Manager() {
		
	}
	
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
