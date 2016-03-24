package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.DeleteProvider;

public class DeleteProviderTest {
	DeleteProvider provider = new DeleteProvider();
	String providerName = "Lairton";
	
	@Test
	public void testDeleteProvider() {
		assertTrue(provider.deleteProvider(providerName));
	}
	
	@Test
	public void testDeleteProviderNullName() {
		assertTrue(provider.deleteProvider(null));
	}
}
