package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author tiago
 * Create a single connection to the database
 */

public final class ConnectionDB {

	protected Connection connectionWithDataBase;
	protected static ConnectionDB dataBase;	

	/**
	 * Create a new connection
	 */
	private ConnectionDB() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "biblioteca";
		String userName = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			this.connectionWithDataBase = DriverManager.getConnection(url + dbName, userName, password);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * It enables the creation of a single connection if it does not already exist
	 * @return a single connection
	 */
	protected static synchronized  ConnectionDB getConnection() {
		assert(dataBase	== null) : "the database variable is null";
		dataBase = new ConnectionDB();
        		
        return dataBase;
	}
}
