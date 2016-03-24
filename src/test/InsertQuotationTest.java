package test;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import controller.InsertQuotation;

public class InsertQuotationTest {
	InsertQuotation quotation = new InsertQuotation();
	Date quotationDate = new Date(0, 0, 0);
	
	@Test(expected = RuntimeException.class)
	public void testInsertQuotationWithoutDate() {
		assertTrue(quotation.insertQuotation("Maria", null));
	}
	
	@Test
	public void testInsertQuotation() {
		assertTrue(quotation.insertQuotation("Matheus", quotationDate));
	}

}
