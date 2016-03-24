package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.DeleteProduct;

public class DeleteProductTest {
	DeleteProduct deleteProduct = new DeleteProduct();
	String productName = "Mouse";
	
	@Test
	public void testDeleteProduct() {
		assertTrue(deleteProduct.deleteProduct(productName));
	}
	
	@Test
	public void testDeleteProductNullName() {
		assertTrue(deleteProduct.deleteProduct(null));
	}
}
