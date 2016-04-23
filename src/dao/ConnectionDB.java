/*
 * Class name: ConnectionDB.java
 * Purpose of class: This class is responsible for create a single connection 
 * to the database.
 * Copyright: This software follows GPL license.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionDB {

	protected Connection connectionWithDataBase;
	protected static ConnectionDB dataBase;	

	// this class is responsible for create a single connection to the database
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

	/*this method enables the creation of a single connection if it does not 
	already exist.*/
	protected static synchronized  ConnectionDB getConnection() {
		if ( dataBase == null ) {
			dataBase = new ConnectionDB();
        }
		else{
			//Nothing to do
		}

        return dataBase;
	}
}
