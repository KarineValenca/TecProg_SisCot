/**
 * File name: ConnectionDB.java
 * Purpose of file: This file is composed by a ConnectionDB class and methods.
 * Copyright: This software follows GPL license.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class name: ConnectionDB
 * Purpose of class: This class is responsible for create a single connection 
 * to the database.
 */
public final class ConnectionDB {

	protected Connection connectionWithDataBase;
	
	/**
	 * Method name: ConnectionDB
	 * Purpose of method: This constructor method creates a new connection with
	 * the database.
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
	
	protected static ConnectionDB dataBase;	
	
	/**
	 * Method name: getConnection
	 * Purpose of method: This method enables the creation of a single 
	 * connection if it does not already exist.
	 * @return dataBase Is used to test if a connection database already exist.
	 * If doesn't the variable is used to creates a ConnectionDB instance. 
	 */
	protected static synchronized  ConnectionDB getConnection() {
		if ( dataBase == null ) {
			dataBase = new ConnectionDB();
        }
		else{
			//Nothing to do
		}

        return dataBase;
	}
	public static Connection getConnectionWithDB(){
		Connection dataBase = getConnection().connectionWithDataBase;
		return dataBase;
	}
}
