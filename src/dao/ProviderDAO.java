package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Provider;

public class ProviderDAO {
	private Connection connection;
	
	public ProviderDAO() {
		this.connection = ConnectionDB.getConnection().connectionWithDataBase;
	}
	
	public boolean insertProvider(Provider provider) {
		assert(provider != null) : "the provider object is null";
		String sql = "insert into Providers (cnpj, nome, email, senha, ddd, "
				+ "telefone, endereco, cidade, estado, cep, authorized) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		
		boolean wasAdded = false;
		
		try {
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
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return wasAdded;
	}
	
	public ArrayList<Provider> listProviders() {
		String sql = "select * from Providers";
		ArrayList<Provider> providers = new ArrayList<Provider>();
		
		try {
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
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return providers;
	}
	
	public boolean deleteProvider(String providerCnpj) {
		assert(providerCnpj != null) : "the provider cnpj is null";
		String sql = "delete from Providers where cnpj = ?";
		boolean wasDeleted = false;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, providerCnpj);
			statement.execute();
			
			wasDeleted = true;
			
			statement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return wasDeleted;
	}
	
	public boolean updateProvider(String cnpjToUpdate, Provider provider) {
		assert(cnpjToUpdate != null) : "the cnpj is null";
		assert(provider != null) : "the provider is null";
		String sql = "update Providers set cnpj=?, nome=?, email=?, senha=?, ddd=?, "
				+ "telefone=?, endereco=?, cidade=?, estado=?, cep=?, authorized=? where cnpj=?";
		boolean wasUpdated = false;
			
		try {
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
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return wasUpdated;
	}
}
