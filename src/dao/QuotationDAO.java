package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;
import model.Quotation;

public class QuotationDAO {
	private Connection connection;

	public QuotationDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}

	/**
	 * Include in the data base a new quotation
	 * 
	 * @param A
	 *            new quotation
	 * @return wasAdd if the quotation was add
	 */

	public int includeQuotation(Quotation quotation) {
		String sql = "insert into Quotation (managerName, quotationDate, quotationIsOn)" + " values (?,?,?)";
		// Date date = new Date(quotation.getquotationDate().getTimeInMillis());
		boolean wasAdd = false;
		int id = 0;

		try {
			System.out.println("values:" + quotation.getManagerName());
			// Prepare param to execut the Query
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setString(1, quotation.getManagerName());
			// statement.setDate(1, date, quotation.getquotationDate());
			statement.setDate(2, quotation.getQuotationDate());
			statement.setBoolean(3, quotation.getQuotationIsOn());
			statement.execute();

			// The product was added

			sql = "select * from Quotation where managerName = ? AND quotationDate = ?";
			statement = this.connection.prepareStatement(sql);

			// Set the first atribute of the query
			statement.setString(1, quotation.getManagerName());
			statement.setDate(2, quotation.getQuotationDate());

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			rs.last();
			id = rs.getInt("id");
			wasAdd = true;

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return id;
	}

	/**
	 * Shows all existing products in the database
	 * 
	 * @return
	 */
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
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				Quotation quotation = new Quotation();

				ArrayList<Product> listProducts = new ArrayList<>();
				listProducts = getListProductsInAQuotation(rs.getInt("id"));

				quotation.setManagerName(rs.getString("managerName"));
				quotation.setQuotationDate(rs.getDate("quotationDate"));
				quotation.setQuotationIsOn(rs.getBoolean("quotationIsOn"));
				quotation.setId(rs.getInt("id"));
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
			
			//Returns a result of the query of search
			ResultSet rs = statement.executeQuery();	
			
			//Stores all the products listed in the array
			while(rs.next()) {
				Quotation quotation = new Quotation();

				ArrayList<Product> listProducts = new ArrayList<>();
				listProducts = getListProductsInAQuotation(rs.getInt("id"));
				
				quotation.setManagerName(rs.getString("managerName"));
				quotation.setQuotationDate(rs.getDate("quotationDate"));
				quotation.setQuotationIsOn(rs.getBoolean("quotationIsOn"));
				quotation.setId(rs.getInt("id"));
				quotation.setProducts(listProducts);
				
				quotationList.add(quotation);
			}
			
			//Close the operators
			statement.close();
		} catch(SQLException e) {	
			e.printStackTrace();			
			throw new RuntimeException(e);
		}
		
		return quotationList;
	}

	public boolean deleteQuotation(int id) {
		String sql = "delete from Quotation where id = ?";
		boolean wasDeleted = false;

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);

			// Set the first atribute of the query
			statement.setInt(1, id);
			statement.execute();

			wasDeleted = true;

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return wasDeleted;
	}

	public boolean updateQuotation(int idToUpdate, Quotation quotation) {
		String sql = "update Quotation set managerName=?, quotationDate=? where id=?";
		boolean wasUpdated = false;

		try {
			PreparedStatement statement = this.connection.prepareStatement(sql);

			// Set the first atribute of the query
			statement.setString(1, quotation.getManagerName());
			statement.setDate(2, quotation.getQuotationDate());
			statement.setInt(3, idToUpdate);

			statement.executeUpdate();

			wasUpdated = true;

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return wasUpdated;
	}
	
	//Change the quotation for closed quotation
	public boolean updateQuotation(int idToUpdate) {
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

	public boolean includeQuotationProduc(Quotation quotation, Product product) {
		String sql = "insert into Quotation_Product_Provider(quotationID, productName)" + " values (?,?)";

		// Date date = new Date(quotation.getquotationDate().getTimeInMillis());
		boolean wasAdd = false;

		try {
			System.out.println("Cotação ID:" + quotation.getId());
			System.out.println("Produto name:" + product.getProductName());
			// Prepare param to execut the Query
			PreparedStatement statement = this.connection.prepareStatement(sql);

			statement.setInt(1, quotation.getId());
			// statement.setDate(1, date, quotation.getquotationDate());
			statement.setString(2, product.getProductName());
			statement.execute();

			// The product was added
			wasAdd = true;

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return wasAdd;
	}

	/**
	 * Shows all existing products in the database
	 * 
	 * @return
	 */
	public ArrayList<Product> getListProductsInAQuotation(int quotationID) {
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

			// Returns a result of the query of search
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			while (rs.next()) {
				Product product = new Product();

				product.setProductName(rs.getString("productName"));
				productList.add(product);
			}

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return productList;
	}

	public Quotation selectQuotationByID(int quotationID) {

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
			ResultSet rs = statement.executeQuery();

			// Stores all the products listed in the array
			rs.last();

			quotation.setId(quotationID);
			quotation.setManagerName(rs.getString("managerName"));
			quotation.setQuotationDate(rs.getDate("quotationDate"));

			// Close the operators
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return quotation;
	}

	public void updateQuotationPrices(ArrayList<String> products, ArrayList<Double> priceOfProducts, 
			int integerQuotationId, String provideName) {
		
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
				
				ResultSet rs = statementQuery.executeQuery();
				
				
				Double value;
				
				rs.last();
				value = rs.getDouble("priceProduct");
				
				if((Math.abs(value - 0) < 0.001) || (value > priceOfProducts.get(i))){
					//Set the first atribute of the query

					statementUpdate.setString(1, provideName);
					statementUpdate.setDouble(2, priceOfProducts.get(i).doubleValue());
					statementUpdate.setInt(3, integerQuotationId);
					statementUpdate.setString(4, products.get(i));

					statementUpdate.executeUpdate();
				}
			}
			
			// Close the operators
			//statementUpdate.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

