package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dao.ConnectionDB;
import dao.ProviderDAO;
import junit.framework.TestCase;
import model.Provider;

public class ProviderDAOTest extends TestCase {
	
	Connection connection = new ConnectionDB().getConnection();
	Provider provider = new Provider();
	ProviderDAO providerDao = new ProviderDAO();
	ResultSet rs;
	PreparedStatement statement;
	ArrayList<Provider> providers = new ArrayList<Provider>();
	int i;
	
	@Test
	public void testInsertProvider() {
		provider.setProviderCnpj("123456789");
		provider.setProviderName("Carrefour");
		provider.setProviderEmail("carrefour@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(12345678);
		provider.setProviderAdress("Quadra 10 Bloco 1");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000123);
		provider.setAuthorized(true);
		
		assertTrue(providerDao.insertProvider(provider));
	}
	
	@Test
	public void testInsertProviderComparingValues() throws SQLException {		
		provider.setProviderCnpj("987654321");
		provider.setProviderName("Extra");
		provider.setProviderEmail("extra@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(87654321);
		provider.setProviderAdress("Quadra 20 Bloco 2");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000234);
		provider.setAuthorized(true);

		providerDao.insertProvider(provider);
		
		String sql = "SELECT cnpj FROM Providers WHERE cnpj = 987654321";
		
		statement = this.connection.prepareStatement(sql);
		rs = statement.executeQuery();
		rs.next();
		String result = rs.getString("cnpj");
		
		assertEquals("987654321", result);
	}
	
	@Test
	public void testListProviders() throws SQLException {		
		providers = providerDao.listProviders();
		
		assertEquals(false, providers.isEmpty());
	}
	
	@Test
	public void testListProvidersComparingValues() throws SQLException {		
		provider.setProviderCnpj("235647683");
		provider.setProviderName("Pao de Acucar");
		provider.setProviderEmail("paoacucar@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(93859485);
		provider.setProviderAdress("Quadra 30 Bloco 3");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000345);
		provider.setAuthorized(true);

		providerDao.insertProvider(provider);
		
		providers = providerDao.listProviders();
		
		boolean providerExists = false;
		
		for(i = 0; i < providers.size(); i++) {
			providerExists = providers.get(i).getProviderCnpj().equals("235647683");
		}
		
		assertTrue(providerExists);
	}
	
	@Test
	public void testDeleteProvider() throws SQLException {
		provider.setProviderCnpj("85048395");
		provider.setProviderName("Veneza");
		provider.setProviderEmail("veneza@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(95747394);
		provider.setProviderAdress("Quadra 40 Bloco 4");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000456);
		provider.setAuthorized(true);
		
		providerDao.insertProvider(provider);
		
		assertTrue(providerDao.deleteProvider("85048395"));
	}
	
	@Test
	public void testDeleteProviderSearchingForTheProvider() throws SQLException {
		provider.setProviderCnpj("8504859492");
		provider.setProviderName("Wallmart");
		provider.setProviderEmail("wallmart@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(85940382);
		provider.setProviderAdress("Quadra 50 Bloco 5");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000567);
		provider.setAuthorized(true);
		
		providerDao.insertProvider(provider);
		providerDao.deleteProvider("8504859492");
		
		providers = providerDao.listProviders();
		boolean providerExists = false;
		
		for(i = 0; i < providers.size(); i++) {
			providerExists = providers.get(i).getProviderCnpj().equals("8504859492");
		}
		
		assertFalse(providerExists);
	}
	
	@Test
	public void testUpdateProvider() throws SQLException {
		provider.setProviderCnpj("29384857");
		provider.setProviderName("BestBuy");
		provider.setProviderEmail("bestbuy@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(74839291);
		provider.setProviderAdress("Quadra 60 Bloco 6");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000678);
		provider.setAuthorized(true);
		
		providerDao.insertProvider(provider);
		
		provider.setProviderName("BestBuyNew");
		
		assertTrue(providerDao.updateProvider("29384857", provider));
	}
	
	@Test
	public void testUpdateProviderSearchingForTheNewUsername() throws SQLException {
		provider.setProviderCnpj("29384857");
		provider.setProviderName("MarketPlace");
		provider.setProviderEmail("bestbuy@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(74839291);
		provider.setProviderAdress("Quadra 60 Bloco 6");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000678);
		provider.setAuthorized(true);
		
		providerDao.insertProvider(provider);
		
		provider.setProviderName("MarketPlaceNew");
		providerDao.updateProvider("29384857", provider);
		
		providers = providerDao.listProviders();
		boolean providerUpdated = false;
		
		for(i = 0; i < providers.size(); i++) {
			providerUpdated = providers.get(i).getProviderCnpj().equals("29384857");
		}
		
		assertTrue(providerUpdated);
	}

}
