/** 
 * File name: ManagerDAO.java
 * Purpose of file: This file contains the ManagerDAO class and its methods.   
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Manager;

/**
 * Class name: ManagerDAO
 * Purpose of class: This class is used to do all actions in the database 
 * relate to manager: insert, delete, update or list a manager.
 */
public class ManagerDAO {
	private Connection connection;

    /** 
     * Method name: ManagerDAO
     * Purpose of method: This method is used to connection in database.  
     */
	public ManagerDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}

    /** 
     * Method name: insertManager
     * Purpose of method: This method is responsible for entering username and
     * password of a	manager in the database, it returns a boolean that returns 
     * true if the manager was added.  
     * @param manager: is instance of Manager to be inserted in the database.
     */
	public boolean insertManager(Manager manager) {
		assert (manager != null) : "unexpected error: the manager object is "
									+ "null";
		String sql;
		sql = "insert into Managers (username, password) values (?,?)";
		boolean wasAdded = false;
		
		try {
			PreparedStatement statement;
			statement = this.connection.prepareStatement(sql);
			statement.setString(1, manager.getManagerUsername());
			statement.setString(2, manager.getManagerPassword());
			statement.execute();
			wasAdded = true;
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}	
		return wasAdded;
	}
 
	/** 
     * Method name: listManagers
     * Purpose of method: This method is responsible for bringing a list managers of database.  
     * @param : there is no param.
     * @return managers: return list of Manager.
     */	
	public ArrayList<Manager> listManagers() {
		String sql;
		sql = "select * from Managers";
		ArrayList<Manager> managers = new ArrayList<Manager>();
		
		try {
			PreparedStatement statement;
			statement = connection.prepareStatement(sql);
			ResultSet rs;
			rs = statement.executeQuery();
			
			while(rs.next()) {
				Manager manager = new Manager();
				manager.setManagerUsername(rs.getString("username"));
				manager.setManagerPassword(rs.getString("password"));		
				managers.add(manager);
			}	
			statement.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return managers;
	}

	/** 
	 * Method name: deleteManager
     * Purpose of method: This method is used to delete a manager at the 
     * database, it returns a boolean that returns true if the manager was 
     * deleted.  
     * @param managerUsername: this string gets the user name of manager from 
     * the view to be deleted in the database.
     * @return wasDeleted: this boolean value is used to verify if the manager
     * was deleted.
     */		
	public boolean deleteManager(String managerUsername) {
		assert(managerUsername != null) : "unexpected error: the manager user "
										   + "name is null";
		String sql;
		sql = "delete from Managers where username = ?";
		boolean wasDeleted;
		wasDeleted = false;

		try {
			PreparedStatement statement;
			statement = connection.prepareStatement(sql);
			statement.setString(1, managerUsername);
			statement.execute();
			wasDeleted = true;
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasDeleted;
	}

	/** 
	 * Method name: updateManager
     * Purpose of method: This method is used to update a manager at the 
     * database, it returns a boolean that returns true if the manager was 
     * updated.  
     * @param usernameToUpdate: This string gets the user name of manager to 
     * update from the view.
     * @param manager: is instance of Manager to be updated in the database.
     * @return wasDeleted: this boolean value is used to verify if the manager
     * was deleted.
     */	
	public boolean updateManager(String usernameToUpdate, Manager manager) {
		assert(usernameToUpdate != null) : "unexpected error: the user name to "
											+ "update is null";
		assert(manager != null) : "unexpected error: the object manager is "
								   + "null";
		String sql;
		sql = "update Managers set username=?, password=? where username=?";
		boolean wasUpdated;
		wasUpdated = false;
			
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, manager.getManagerUsername());
			statement.setString(2, manager.getManagerPassword());
			statement.setString(3, usernameToUpdate);
			statement.executeUpdate();
			wasUpdated = true;
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return wasUpdated;
	}
}
