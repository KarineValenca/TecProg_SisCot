/*
 * Class name: ManagerDAO.java
 * Purpose of class: This class is used to insert, delete, update or list a 
 * manager.
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Manager;

public class ManagerDAO {
	private Connection connection;
	
	public ManagerDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}

	/* this method is responsible for entering username and password of a 
	manager in the database.*/
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

	// this method is responsible for bringing a list managers of database. 	
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
	
	// this method is responsible for delete a manager of database.
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
	
	// this method is responsible for update a manager of database.	
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
