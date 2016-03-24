package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.DeleteQuotation;

public class DeleteQuotationTest {
	DeleteQuotation quotation = new DeleteQuotation();
	
	@Test
	public void testDeleteQuotation() {
		assertTrue(quotation.deleteQuotation(10));
	}
	
	@Test
	public void testDeleteQuotationOutOfIndex() {
		assertTrue(quotation.deleteQuotation(-1));
	}
}
