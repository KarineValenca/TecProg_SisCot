package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import dao.ConnectionDB;
import dao.ProviderDAO;
import junit.framework.TestCase;
import model.Provider;

public class ProviderDAOTest extends TestCase {
	
	@Test
	public void testSucessInsertProvider(){
		Provider provider = new Provider();
		provider.setProviderCnpj("123456");
		provider.setProviderName("test");
		provider.setProviderEmail("test@test.com");
		provider.setProviderPassword("test");
		provider.setProviderDdd(61);
		provider.setProviderPhone(32313231);
		provider.setProviderAdress("test");
		provider.setProviderCity("test");
		provider.setProviderCity("test");
		provider.setProviderZip(72123);
		provider.setAuthorized(false);
		
		boolean wasInserted = false;
		ProviderDAO providerDAO = new ProviderDAO();
		wasInserted = providerDAO.insertProvider(provider);
		
		assertTrue(wasInserted);
		
	}
	
	@Test
	public void testSuccessDeleteProvider(){
		ProviderDAO providerDAO = new ProviderDAO();
		boolean wasDeleted = false;
		wasDeleted = providerDAO.deleteProvider("123456");
		
		assertTrue(wasDeleted);
		
	}
}
