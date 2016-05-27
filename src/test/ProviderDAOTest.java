package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import dao.ConnectionDB;
import dao.ProviderDAO;
import junit.framework.TestCase;
import model.Provider;

public class ProviderDAOTest extends TestCase {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
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
	
	/*@Test(expected = AssertionError.class)
	public void testFailDeleteProvider(){
		ProviderDAO providerDAO = new ProviderDAO();
		boolean wasDeleted = false;
		wasDeleted = providerDAO.deleteProvider(null);
		
		assertFalse(wasDeleted);
		
	}*/
	
	@Test
	public void testSucessUpdateProvider(){
		Provider provider = new Provider();
		provider.setProviderCnpj("123456");
		provider.setProviderName("testando");
		provider.setProviderEmail("test@test.com");
		provider.setProviderPassword("test");
		provider.setProviderDdd(61);
		provider.setProviderPhone(32313231);
		provider.setProviderAdress("test");
		provider.setProviderCity("test");
		provider.setProviderCity("test");
		provider.setProviderZip(72123);
		provider.setAuthorized(false);
		
		boolean wasUpdated = false;
		ProviderDAO providerDAO = new ProviderDAO();
		
		wasUpdated = providerDAO.updateProvider("123456", provider);
		
		assertTrue(wasUpdated);
	}
}
