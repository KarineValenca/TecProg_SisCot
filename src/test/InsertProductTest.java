package test;

import java.sql.Connection;

import org.junit.Test;

import controller.InsertProduct;
import dao.ConnectionDB;
import dao.ProductDAO;
import junit.framework.TestCase;
import model.Product;

public class InsertProductTest extends TestCase {

	Connection connection = ConnectionDB.getConnectionWithDB();
	Product product = new Product();
	ProductDAO productDao = new ProductDAO();
	InsertProduct insertProduct = new InsertProduct();	

	@Test
	public void testNameProductNull() {
		try {
			String nameProductNull = null;
			int returnOfInsertProduct = insertProduct
					.insertProduct(nameProductNull);
			assertFalse(true);
		} catch (AssertionError nameNullError) {
			assertTrue(true);
		}
	}

	@Test
	public void testExceptionDataBase() {
		StringBuilder incorrectNameProduct = new StringBuilder();
		for (int i =0; i<= 255; i++){
			incorrectNameProduct.append("a");
		}
		int returnOfInsertProduct = insertProduct
				.insertProduct(incorrectNameProduct.toString());
		assertEquals("Return method is 0 for strings equal or bigger than 255",
				0, returnOfInsertProduct);
	}

	@Test
	public void testCorrectNameProduct() {
		String correctNameProduct = "leite";
		int returnOfInsertProduct = insertProduct
				.insertProduct(correctNameProduct);
		assertEquals("Return method is 1 for sucessful insert", 1,
				returnOfInsertProduct);
	}

	@Test
	public void testNameProductTrim() {
		String nameInBlank = "         ";
		int returnOfInsertProduct = insertProduct.insertProduct(nameInBlank);
		assertEquals("Return method is 2 for empty strings", 2,
				returnOfInsertProduct);
	}
	
	@Test
	public void testMessageHandlingNotAdded() {
		Integer valueForMessage = 0;
		String returnOfMessageHandling = insertProduct.messageHandling(valueForMessage);
		assertEquals("Return method is that product was not added", 
				"Produto Não Foi Adicionado!", returnOfMessageHandling);
	}
	
	@Test
	public void testMessageHandlingAdded() {
		Integer valueForMessage = 1;
		String returnOfMessageHandling = insertProduct.messageHandling(valueForMessage);
		assertEquals("Return method is that product was added", 
				"Produto adicionado com sucesso!", returnOfMessageHandling);
	}
	
	@Test
	public void testMessageHandlingNameInBlank() {
		Integer valueForMessage = 2;
		String returnOfMessageHandling = insertProduct.messageHandling(valueForMessage);
		assertEquals("Return method is that the product name is blank", 
				"Nome do Produto em branco! Por favor, preencha com um nome", 
				returnOfMessageHandling);
	}
	
	@Test
	public void testMessageHandlingInvalidValue() {
		Integer valueForMessage = 3;
		String returnOfMessageHandling = insertProduct.messageHandling(valueForMessage);
		assertEquals("Return method is that value is invalid",
				"Valor invalido no método messageHandling!",
				returnOfMessageHandling);
	}
	
}

	