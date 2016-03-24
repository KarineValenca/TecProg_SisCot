package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dao.ConnectionDB;
import dao.ProductDAO;
import junit.framework.TestCase;
import model.Product;

public class ProductDAOTest extends TestCase {
	
	Connection connection = new ConnectionDB().getConnection();
	Product product = new Product();
	ProductDAO productDao = new ProductDAO();
	ResultSet rs;
	PreparedStatement statement;
	ArrayList<Product> products = new ArrayList<Product>();
	int i;
	
	@Test
	public void testInsertProduct() {		
		product.setProductName("Arroz");
		
		assertEquals(true, productDao.insertProduct(product));		
	}
	
	@Test
	public void testInsertProductComparingValues() throws SQLException {		
		product.setProductName("Feijão");

		productDao.insertProduct(product);
		
		String sql = "SELECT nome FROM Products WHERE description = '1kg'";
		
		statement = this.connection.prepareStatement(sql);
		rs = statement.executeQuery();
		rs.next();
		String result = rs.getString("nome");
		
		assertEquals("Feijão", result);
	}
	
	@Test
	public void testListProducts() throws SQLException {		
		products = productDao.listProducts();
		
		assertEquals(false, products.isEmpty());
	}
	
	@Test
	public void testListProductsComparingValues() throws SQLException {		
		product.setProductName("Detergente");

		productDao.insertProduct(product);
		
		products = productDao.listProducts();
		
		boolean elementExists = false;
		
		for(i = 0; i < products.size(); i++) {
			elementExists = products.get(i).getProductName().equals("Detergente");
		}
		
		assertTrue(elementExists);
	}
	
	@Test
	public void testDeleteProduct() throws SQLException {
		product.setProductName("RemoverProduto");
		
		productDao.insertProduct(product);
		
		assertTrue(productDao.deleteProduct("RemoverProduto"));
	}
	
	@Test
	public void testDeleteProductSearchingForTheProduct() throws SQLException {
		product.setProductName("RemoverProduto2");
		
		productDao.insertProduct(product);
		productDao.deleteProduct("RemoverProduto2");
		
		products = productDao.listProducts();
		boolean elementExists = false;
		
		for(i = 0; i < products.size(); i++) {
			if(products.get(i).getProductName() == "RemoverProduto2") {
				elementExists = true;
			}
		}
		
		assertFalse(elementExists);
	}
	
	@Test
	public void testUpdateProduct() throws SQLException {
		product.setProductName("Atualizar");
		
		productDao.insertProduct(product);
		
		product.setProductName("ProdutoAtualizado1");
		
		assertTrue(productDao.updateProduct("Produto", product));
	}
	
	@Test
	public void testUpdateProductSearchingForTheNewName() throws SQLException {
		product.setProductName("Produto");
		
		productDao.insertProduct(product);
		
		product.setProductName("ProdutoAtualizado2");
		productDao.updateProduct("Produto", product);
		
		products = productDao.listProducts();
		boolean productUpdated = false;
		
		for(i = 0; i < products.size(); i++) {
			productUpdated = products.get(i).getProductName().equals("ProdutoAtualizado2");
		}
		
		assertTrue(productUpdated);
	}
}
