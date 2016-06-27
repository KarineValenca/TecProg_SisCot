package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.InsertProvider;
import model.Provider;

public class InsertProviderTest {
	Provider provider = new Provider();
	InsertProvider insertProvider = new InsertProvider();
	
	@Test
	public void testNameProvidertNull() {
		String nameProviderNull = null;
		
		provider.setProviderCnpj("123456789");
		provider.setProviderName(nameProviderNull);
		provider.setProviderEmail("carrefour@gmail.com");
		provider.setProviderPassword("senha123");
		provider.setProviderDdd(61);
		provider.setProviderPhone(12345678);
		provider.setProviderAdress("Quadra 10 Bloco 1");
		provider.setProviderCity("Brasilia");
		provider.setProviderState("DF");
		provider.setProviderZip(70000123);
		provider.setAuthorized(true);
		
		assertFalse(insertProvider.insertProvider(provider));
	}

	@Test
	public void testAuthorizedFalse() {		
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
		provider.setAuthorized(false);
		
		assertTrue(insertProvider.insertProvider(provider));
	}
	
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
		
		assertTrue(insertProvider.insertProvider(provider));
	}

}
