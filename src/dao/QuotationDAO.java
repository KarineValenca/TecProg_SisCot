/** 
 * File name: QuotationDAO.java
 * Purpose of file: This file contains the QuotationDAO class and its methods.   
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
import model.Quotation;

/**
 * Class name: QuotationDAO
 * Purpose of class: This class is used to do all actions in the database
 * relate to manager: insert, delete, update or list a quotation.
 */
public class QuotationDAO {
	private Connection connection;

	public QuotationDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}
	
    /** 
     * Method name: includeQuotation
     * Purpose of method: This method is used to include in the data base a new quotation.  
     * @param quotation: there is a object quotation.
	 * @return wasAdd: return if the quotation was add.
     */
	public int includeQuotation(Quotation quotation) {
		assert (quotation != null) : "unexpected error: the quotation object is null";
		String sql = "insert into Quotation (managerName, quotationDate, quotationIsOn)" 
				+ " values (?,?,?)";
		int id = 0;

		try {
			String managerName;
			managerName =  quotation.getManagerName();
			System.out.println("values:" + managerName);
			//System.out.println("values:" + quotation.getManagerName());
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, quotation.getManagerName());
			statement.setDate(2, quotation.getQuotationDate());
			statement.setBoolean(3, quotation.getQuotationIsOn());
			statement.execute();

			sql = "select * from Quotation where managerName = ? AND quotationDate = ?";
			statement = this.connection.prepareStatement(sql);
			statement.setString(1, quotation.getManagerName());
			statement.setDate(2, quotation.getQuotationDate());
			ResultSet result = statement.executeQuery();

			result.last();
			id = result.getInt("id");

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return id;
	}

    /** 
    * Method name: listQuotation
    * Purpose of method: This method is used to list all quotations at the database.  
    * @param: there is no return.
	* @return quotationList: return list of quotation.
    **/
	public ArrayList<Quotation> listQuotation() {
		String sql = "select * from Quotation";
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);

			// Returns a result of the query of search
			ResultSet result = statement.executeQuery();

			// Stores all the products listed in the array
			while (result.next()) {
				Quotation quotation = new Quotation();

				ArrayList<Product> listProducts = new ArrayList<>();
				int id = result.getInt("id");
				listProducts = getListProductsInAQuotation(id);
				String managerName = result.getString("managerName");
				quotation.setManagerName(managerName);
				quotation.setQuotationDate(result.getDate("quotationDate"));
				boolean quotationIsOn = result.getBoolean("quotationIsOn");
				quotation.setQuotationIsOn(quotationIsOn);
				int idQuotation = result.getInt("id");
				quotation.setId(idQuotation);
				quotation.setProducts(listProducts);

				quotationList.add(quotation);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return quotationList;
	}

    /** 
    * Method name: listQuotationProvider
    * Purpose of method: This method is used to list all quotations providers 
    * at the database.  
    * @param: there is no param.
	* @return quotationList: return list of quotation.
    **/
	public ArrayList<Quotation> listQuotationProvider() {
		String sql = "select * from Quotation where quotationIsOn = true";
		ArrayList<Quotation> quotationList= new ArrayList<Quotation>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();	
			while(result.next()) {
				Quotation quotation = new Quotation();
				ArrayList<Product> listProducts = new ArrayList<>();
				int id = result.getInt("id");
				listProducts = getListProductsInAQuotation(id);
				String managerName = result.getString("managerName");
				quotation.setManagerName(managerName);
				quotation.setQuotationDate(result.getDate("quotationDate"));
				boolean quotationIsOn = result.getBoolean("quotationIsOn");
				quotation.setQuotationIsOn(quotationIsOn);
				int idQuotation = result.getInt("id");
				quotation.setId(idQuotation);
				quotation.setProducts(listProducts);
				quotationList.add(quotation);
			}
			statement.close();
		} catch(SQLException e) {	
			e.printStackTrace();			
			throw new RuntimeException(e);
		}
		
		return quotationList;
	}

    /** 
    * Method name: deleteQuotation
    * Purpose of method: This method is used to list all quotations providers 
    * at the database.  
    * @param id: identifies the quotation to be deleted.
	* @return wasDeleted: this boolean value is used to verify if the quotation
    * was deleted.
    **/
	public boolean deleteQuotation(int id) {
		assert(id >=1) : "unexpected error: the informed id is invalid";
		String sql = "delete from Quotation where id = ?";
		boolean wasDeleted = false;

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
			wasDeleted = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return wasDeleted;
	}

    /** 
    * Method name: updateQuotation
    * Purpose of method: This method is used to change for closed quotation at 
    * the database, it returns a boolean that returns true if the manager was updated.
    * @param idToUpdate: identifies the quotation to be updated.
    * @param quotation: there is a object quotation.
	* @return wasUpdated: This boolean attribute is used to verify if a quotation 
	* as updated to the database.
    **/
	public boolean updateQuotation(int idToUpdate, Quotation quotation) {
		assert(idToUpdate >=1) : "unexpected error: the informed id is invalid";
		assert (quotation != null) : "unexpected error: the quotation object is null";
		String sql = "update Quotation set managerName=?, quotationDate=? where id=?";
		boolean wasUpdated = false;

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, quotation.getManagerName());
			statement.setDate(2, quotation.getQuotationDate());
			statement.setInt(3, idToUpdate);
			statement.executeUpdate();
			wasUpdated = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wasUpdated;
	}

	// Verify method - refactor
	//Change the quotation for closed quotation
	public boolean updateQuotation(int idToUpdate) {
		assert(idToUpdate >=1) : "unexpected error: the informed id is invalid";
		String sql = "update Quotation set quotationIsOn=? where id=?";
		boolean wasUpdated = false;

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			// Set the first atribute of the query
			statement.setBoolean(1, false);
			statement.setInt(2, idToUpdate);
			statement.executeUpdate();
			wasUpdated = true;
			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wasUpdated;
	}
	
    /** 
    * Method name: includeQuotationProduc
    * Purpose of method: This method is used to include quotation at the database,
    * it returns a boolean that returns true if the manager was included.
    * @param quotation: there is a object quotation.
    * @param product: there is a object product.
	* @return wasAdd: This boolean attribute is used to verify if a product quotation 
	* as included to the database.
    **/
	public boolean includeQuotationProduc(Quotation quotation, Product product) {
		assert (quotation != null) : "unexpected error: the quotation object is null";
		assert (product != null) : "unexpected error: the quotation object is null";
		String sql = "insert into Quotation_Product_Provider(quotationID, productName)" 
					+ " values (?,?)";
		boolean wasAdd = false;

		try {
			System.out.println("Cotação ID:" + quotation.getId());
			System.out.println("Produto name:" + product.getProductName());
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, quotation.getId());
			statement.setString(2, product.getProductName());
			statement.execute();
			wasAdd = true;
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return wasAdd;
	}
	
    /** 
    * Method name: getListProductsInAQuotation
    * Purpose of method: This method is used list all products in a quotations 
    * at the database.
    * @param quotationID: unique identifier the quotation.
	* @return productList: list of product.
    **/
	public ArrayList<Product> getListProductsInAQuotation(int quotationID) {
		assert(quotationID >=1) : "unexpected error: the informed id is invalid";
		String sql = "select * from Quotation_Product_Provider where quotationID = ?";
		ArrayList<Product> productList = new ArrayList<Product>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setInt(1, quotationID);
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				Product product = new Product();
				product.setProductName(result.getString("productName"));
				productList.add(product);
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return productList;
	}

    /** 
    * Method name: getListProductsInAQuotation
    * Purpose of method: This method is used list all products in a quotations 
    * at the database.
    * @param quotationID: unique identifier the quotation.
	* @return productList: list of quotation.
    **/	
	public Quotation selectQuotationByID(int quotationID) {
		assert(quotationID >=1) : "unexpected error: the informed id is invalid";
		String sql = "select * from Quotation where id = ?";
		Quotation quotation = new Quotation();

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, quotationID);

			// Returns a result of the query of search
			ResultSet result = statement.executeQuery();

			// Stores all the products listed in the array
			result.last();

			quotation.setId(quotationID);
			quotation.setManagerName(result.getString("managerName"));
			quotation.setQuotationDate(result.getDate("quotationDate"));

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return quotation;
	}

    /** 
    * Method name: updateQuotationPrices
    * Purpose of method: This method is used to update a price of product quotation
    * at the database, it returns a boolean that returns true if the manager was updated.
    * @param products: list of products.
    * @param priceOfProducts: price of product. 
    * @param integerQuotationID: unique identifier the quotation.
    * @param provideName: name of provider.
	* @return productList: list of quotation.
    **/	
	public void updateQuotationPrices(ArrayList<String> products, 
									  ArrayList<Double> priceOfProducts, 
									  int integerQuotationId, String provideName) {
		assert(integerQuotationId >=1) : "unexpected error: the informed id is invalid";
		assert (provideName != null) : "unexpected error: the provide Name is null";
		String sqlUpdate = "update Quotation_Product_Provider set providerName=?, priceProduct=? "
				+ "where quotationID=? AND productName=?";
		
		String sqlQuery = "select priceProduct from Quotation_Product_Provider "
				+ " where quotationID=? AND productName=?";
		

		try {
			PreparedStatement statementUpdate = this.connection.prepareStatement(sqlUpdate);
			
			PreparedStatement statementQuery = this.connection.prepareStatement(sqlQuery);
			
			for (int i = 0; i < priceOfProducts.size(); ++i) {
				statementQuery.setInt(1, integerQuotationId);
				statementQuery.setString(2, products.get(i));				
				ResultSet result = statementQuery.executeQuery();		
				Double value;
				
				result.last();
				value = result.getDouble("priceProduct");
				
				if((Math.abs(value - 0) < 0.001) || (value > priceOfProducts.get(i))){
					statementUpdate.setString(1, provideName);
					statementUpdate.setDouble(2, priceOfProducts.get(i).doubleValue());
					statementUpdate.setInt(3, integerQuotationId);
					statementUpdate.setString(4, products.get(i));
					statementUpdate.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}