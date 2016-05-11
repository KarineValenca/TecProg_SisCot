/**
 * File name: ReportDAO.java 
 * Purpose of file: This file contains the ReportDAO class and its methods.
 * Copyright: This software follows GPL license.
 **/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class name: ReportDAO
 * Purpose of class: This class is used to generate reports. These reports are 
 * useful to the user check information about prices, providers and products. 
 **/
public class ReportDAO {

	private Connection connection;

	public ReportDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}
	
	/**
	 * Method name: listProductsManager
	 * Purpose of method: This method is used to list all products name related
	 * to a quotation.
	 * @param id: this attribute is integer type and it is used to get the 
	 * the productName from a Quotation based on this id.    
	 * @return: it returns an arraylist of string type with all products with
	 * this quotation id.
	 **/
	public ArrayList<String> listProductsManager(int id) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id > 0) : "unexpected error: the informed id is invalid";
		
		ArrayList<String> productsManager = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			String sql = "select productName from Quotation_Product_Provider where "
					+ "quotationID = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, id);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				String product;
				product = rs.getString("productName");

				productsManager.add(product);
			}

			// Close the operators
			statement.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productsManager;
	}

	/**
	 * Method name: listProvidersManager
	 * Purpose of method: This method is used to list all providers name 
	 * related to a quotation.
	 * @param id: this attribute is integer type and it is used to get the 
	 * the product provider from a Quotation based on this id.    
	 * @return: it returns an arraylist of string type with all providers with
	 * this quotation id.
	 **/
	public ArrayList<String> listProvidersManager(int id) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id > 0) : "unexpected error: the informed id is invalid";
				
		String sql = "select providerName from Quotation_Product_Provider where "
						+ "quotationID = ?";
		ArrayList<String> providersManager = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, id);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				String product;
				product = rs.getString("providerName");

				if(product == null) {
					product = "Produto não possui fornecedor!";
				} 
				else {
					// NOTHING TO DO
				}
				providersManager.add(product);
			}

			// Close the operators
			statement.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return providersManager;
	}

	/**
	 * Method name: listProductsProvider
	 * Purpose of method: This method is used to list all products name related
	 * to a quotation and a provider.
	 * @param id: this attribute is integer type and it is used to get the 
	 * product name from a Quotation based on this id. 
	 * @param providerName: this attribute is string type and it is used to get
	 * the product name from a provider based on this string.    
	 * @return: it returns an arraylist of string type with all products with
	 * this quotation id and this provider name.
	 **/
	public ArrayList<String> listProductsProvider(int id, String providerName) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id > 0) : "unexpected error: the informed id is invalid";
		assert(providerName != null) : "unexpected error: the providerName is "
										+ "null";
		
		ArrayList<String> productsProvider = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			String sql = "select productName from Quotation_Product_Provider where "
					+ "quotationID = ? AND  providerName = ? ";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.setString(2, providerName);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				String product;
				product = rs.getString("productName");

				productsProvider.add(product);
			}

			// Close the operators
			statement.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productsProvider;
	}

	/**
	 * Method name: listProvidersProvider
	 * Purpose of method: This method is used to list all providers related to 
	 * a quotation and a provider.
	 * @param id: this attribute is integer type and it is used to get the 
	 * product name from a Quotation based on this id. 
	 * @param providerName: this attribute is string type and it is used to get
	 * the product name from a provider based on this string.    
	 * @return: it returns an arraylist of string type with all products with
	 * this quotation id and this provider name.
	 **/
	public ArrayList<String> listProvidersProvider(int id, String providerName) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id > 0) : "unexpected error: the informed id is invalid";
		assert(providerName != null) : "unexpected error: the providerName is "
										+ "null";
		
		ArrayList<String> providersToProvider = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			String sql = "select providerName from Quotation_Product_Provider where "
					+ "quotationID = ? AND providerName = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.setString(2, providerName);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				String product;
				product = rs.getString("providerName");

				providersToProvider.add(product);
			}

			// Close the operators
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return providersToProvider;
	}

	/**
	 * Method name: listPriceProducts
	 * Purpose of method: This method is used to list all products price related
	 * to a quotation.
	 * @param id: this attribute is integer type and it is used to get the 
	 * product price from a Quotation based on this id. 
	 * @return: it returns an arraylist of double type with all products prices
	 * related to a quotation.
	 **/
	public ArrayList<Double> listPriceProducts(int id) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id > 0) : "unexpected error: the informed id is invalid";
		
		ArrayList<Double> priceProducts = new ArrayList<Double>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			String sql = "select priceProduct from Quotation_Product_Provider where "
					+ "quotationID = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, id);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				Double price;
				price = rs.getDouble("priceProduct");
				priceProducts.add(price);
			}

			// Close the operators
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return priceProducts;
	}

	/**
	 * Method name: listPriceProductsProvider
	 * Purpose of method: This method is used to list all products price related
	 * to a quotation and a provider.
	 * @param id: this attribute is integer type and it is used to get the 
	 * product price from a Quotation based on this id. 
	 * @param providerName: this attribute is string type and it is used to get
	 * the product price from a provider based on this string.
	 * @return: it returns an arraylist of double type with all products prices
	 * related to a quotation and a provider.
	 **/
	public ArrayList<Double> listPriceProductsProvider(int id, String providerName) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id > 0) : "unexpected error: the informed id is invalid";
		assert(providerName != null) : "unexpected error: the providerName is null";
		
		ArrayList<Double> priceProducts = new ArrayList<Double>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			String sql = "select priceProduct from Quotation_Product_Provider " 
					+ "where quotationID = ?  AND providerName = ?";
			
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, id);
			statement.setString(2, providerName);

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				Double price;
				price = rs.getDouble("priceProduct");
				priceProducts.add(price);
			}

			// Close the operators
			statement.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return priceProducts;
	}
	
}