package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
import model.Quotation;

public class ReportDAO {

	private Connection connection;

	public ReportDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}

	public ArrayList<String> listProductsManager(int id) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id >=0) : "unexpected error: the informed id is invalid";
		
		String sql = "select productName from Quotation_Product_Provider " + "where quotationID = ?";
		ArrayList<String> productsManager = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
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
				product = rs.getString("productName");

				productsManager.add(product);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productsManager;
	}

	public ArrayList<String> listProvidersManager(int id) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id >=0) : "unexpected error: the informed id is invalid";
				
		String sql = "select providerName from Quotation_Product_Provider " + "where quotationID = ?";
		ArrayList<String> providersManager = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
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

				if (product == null)
					product = "Produto não possui fornecedor!";

				providersManager.add(product);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return providersManager;
	}

	public ArrayList<String> listProductsProvider(int id, String providerName) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id >=0) : "unexpected error: the informed id is invalid";
		assert(providerName != null) : "unexpected error: the providerName is null";
		
		String sql = "select productName from Quotation_Product_Provider "
				+ " where quotationID = ? AND  providerName = ? ";
		ArrayList<String> productsProvider = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productsProvider;
	}

	public ArrayList<String> listProvidersProvider(int id, String providerName) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id >=0) : "unexpected error: the informed id is invalid";
		assert(providerName != null) : "unexpected error: the providerName is null";
		
		String sql = "select providerName from Quotation_Product_Provider "
				+ "where quotationID = ? AND providerName = ?";
		ArrayList<String> providersToProvider = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return providersToProvider;
	}

	public ArrayList<Double> listPriceProducts(int id) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id >=0) : "unexpected error: the informed id is invalid";
		
		String sql = "select priceProduct from Quotation_Product_Provider " + "where quotationID = ?";
		ArrayList<Double> priceProducts = new ArrayList<Double>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
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

				Double price;
				price = rs.getDouble("priceProduct");
				priceProducts.add(price);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return priceProducts;
	}

	public ArrayList<Double> listPriceProductsProvider(int id, String providerName) {
		//if the id is equal or less than zero, it means that the id is invalid. 
		assert(id >=0) : "unexpected error: the informed id is invalid";
		assert(providerName != null) : "unexpected error: the providerName is null";
		
		String sql = "select priceProduct from Quotation_Product_Provider " 
				+ "where quotationID = ?  AND providerName = ?";
		ArrayList<Double> priceProducts = new ArrayList<Double>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return priceProducts;
	}
}
