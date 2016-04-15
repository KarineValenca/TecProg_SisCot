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
	
	public boolean insertManager(Manager manager) {
		assert (manager != null) : "unexpected error: the manager object is null";
		String sql = "insert into Managers (username, password) values (?,?)";
		boolean wasAdded = false;
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
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
	
	public ArrayList<Manager> listManagers() {
		String sql = "select * from Managers";
		ArrayList<Manager> managers = new ArrayList<Manager>();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
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
	
	public boolean deleteManager(String managerUsername) {
		assert(managerUsername != null) : "unexpected error: the manager user name is null";
		String sql = "delete from Managers where username = ?";
		boolean wasDeleted = false;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, managerUsername);
			statement.execute();
			
			wasDeleted = true;
			
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasDeleted;
	}
	
	public boolean updateManager(String usernameToUpdate, Manager manager) {
		assert(usernameToUpdate != null) : "unexpected error: the user name to update is null";
		assert(manager != null) : "unexpected error: the object manager is null";
		String sql = "update Managers set username=?, password=? where username=?";
		boolean wasUpdated = false;
			
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
