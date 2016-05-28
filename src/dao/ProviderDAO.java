/**
 * File name: ProviderDAO.java 
 * Purpose of file: This file contains the ProviderDAO class and its methods.
 * Copyright: This software follows GPL license.
 **/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Provider;

/**
 * Class name: ProviderDAO
 * Purpose of class: This class is used to insert, delete, update or list a 
 * provider. 
 **/
public class ProviderDAO {
	private Connection connection;
	
	public ProviderDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}
	
	/**
	 * Method name: insertProvider
	 * Purpose of method: This method is used to insert a provider at the database.
	 * @param provider: instance of the object Provider that will be created.   
	 * @return: it returns a boolean, that returns true if the provider was added
	 * and false if the provider was not added.
	 **/
	public boolean insertProvider(Provider provider) {
		assert (provider != null) : "unexpected error: the provider object is "
									+ "null";
		boolean wasAdded = false;
		
		try {
			String sql = "insert into Providers (cnpj, nome, email, senha, ddd, "
					+ "telefone, endereco, cidade, estado, cep, authorized) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = this.connection.prepareStatement(sql);
			
			statement.setString(1, provider.getProviderCnpj());
			statement.setString(2, provider.getProviderName());
			statement.setString(3, provider.getProviderEmail());
			statement.setString(4, provider.getProviderPassword());
			statement.setInt(5, provider.getProviderDdd());
			statement.setInt(6, provider.getProviderPhone());
			statement.setString(7, provider.getProviderAdress());
			statement.setString(8, provider.getProviderCity());
			statement.setString(9, provider.getProviderState());
			statement.setInt(10, provider.getProviderZip());
			statement.setBoolean(11, provider.isAuthorized());
			statement.execute();
		
			wasAdded = true;
			
			statement.close();
		} 
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return wasAdded;
	}
	
	/**
	 * Method name: listProviders
	 * Purpose of method: This method is used to list all providers at the 
	 * database.
	 * @param: there is no param.
	 * @return: it returns a arraylist of provider type with all providers at
	 * system.
	 **/
	public ArrayList<Provider> listProviders() {
		ArrayList<Provider> providers = new ArrayList<Provider>();
		
		try {
			String sql = "select * from Providers";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Provider provider = new Provider();
				
				provider.setProviderCnpj(rs.getString("cnpj"));
				provider.setProviderName(rs.getString("nome"));
				provider.setProviderEmail(rs.getString("email"));
				provider.setProviderPassword(rs.getString("senha"));
				provider.setProviderDdd(rs.getInt("ddd"));
				provider.setProviderPhone(rs.getInt("telefone"));
				provider.setProviderAdress(rs.getString("endereco"));
				provider.setProviderCity(rs.getString("cidade"));
				provider.setProviderState(rs.getString("estado"));
				provider.setProviderZip(rs.getInt("cep"));
				provider.setAuthorized(rs.getBoolean("authorized"));
				
				providers.add(provider);
			}
			statement.close();
		} 
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return providers;
	}
	
	/**
	 * Method name: deleteProvider
	 * Purpose of method: This method is used to delete a provider at the 
	 * database.
	 * @param providerCnpj: this attribute is the provider CNPJ. CNPJ is a 
	 * company register number in Brazil, and can be used as an identifier.
	 * @return: it returns a boolean, that returns true if the provider was 
	 * deleted and false if the provider was not deleted.
	 **/
	public boolean deleteProvider(String providerCnpj) {
		assert(providerCnpj != null) : "unexpected error: the provider cnpj is "
										+ "null";
	
		boolean wasDeleted = false;

		try {
			String sql = "delete from Providers where cnpj = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, providerCnpj);
			statement.execute();
			
			wasDeleted = true;
			
			statement.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasDeleted;
	}
	
	/**
	 * Method name: updateProvider
	 * Purpose of method: This method is used to update a provider at the 
	 * database.
	 * @param cnpjToUpdate: this attribute is the CNPJ number of provider that
	 * will be updated. CNPJ is a company register number in Brazil, and can be
	 * used as an identifier.
	 * @param provider: instance of the object Provider that will be updated.
	 * @return: it returns a boolean, that returns true if the provider was 
	 * updated and false if the provider was not updated.
	 **/
	public boolean updateProvider(String cnpjToUpdate, Provider provider) {
		assert(cnpjToUpdate != null) : "unexpected error: the cnpj is null";
		assert(provider != null) : "unexpected error: the provider is null";
				
		boolean wasUpdated = false;
			
		try {
			String sql = "update Providers set cnpj=?, nome=?, email=?, senha=?, "
					+ "ddd=?, telefone=?, endereco=?, cidade=?, estado=?, cep=?, "
					+ "authorized=? where cnpj=?";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, provider.getProviderCnpj());
			statement.setString(2, provider.getProviderName());
			statement.setString(3, provider.getProviderEmail());
			statement.setString(4, provider.getProviderPassword());
			statement.setInt(5, provider.getProviderDdd());
			statement.setInt(6, provider.getProviderPhone());
			statement.setString(7, provider.getProviderAdress());
			statement.setString(8, provider.getProviderCity());
			statement.setString(9, provider.getProviderState());
			statement.setInt(10, provider.getProviderZip());
			statement.setBoolean(11, provider.isAuthorized());		
			statement.setString(12, cnpjToUpdate);
			
			statement.executeUpdate();
			wasUpdated = true;
			
			statement.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
		return wasUpdated;
	}
	
}