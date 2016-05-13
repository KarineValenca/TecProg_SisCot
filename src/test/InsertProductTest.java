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
	public void testCorrectNameProduct(){
		String correctNameProduct = "leite";
		int returnOfInsertProduct = insertProduct.insertProduct(correctNameProduct);
		assertEquals("Return method is 1 for sucessful insert",1,returnOfInsertProduct);
	}
	
	@Test
	public void testNameProductTrim() {
		String nameInBlank = "         ";
		int returnOfInsertProduct = insertProduct.insertProduct(nameInBlank);
		assertEquals("Return method is 2 for empty strings",2,returnOfInsertProduct);
	}

	
}
