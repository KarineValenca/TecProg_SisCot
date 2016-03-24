/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.InsertProduct;

/**
 * @author tiago
 *
 */
public class ProductTeste {
	
	@Test
	public void testIfReturnsTrueWithCorrectNameAndDescripriton() {
		InsertProduct includeProduct = new InsertProduct();
		String nameProduct = "Orange";
		
		boolean aceptedNameAndDescription= false;
		aceptedNameAndDescription = includeProduct.insertProduct(nameProduct);
		
		assertEquals(true, aceptedNameAndDescription);
	}
	
	@Test
	public void testIfReturnsFalseWithIncorrectName() {
		InsertProduct includeProduct = new InsertProduct();
		String nameProduct = null;
		
		boolean aceptedNameAndDescription= true;
		try{
			aceptedNameAndDescription = includeProduct.insertProduct(nameProduct);
		}
		catch(Exception e){
			aceptedNameAndDescription = false;
		}
		
		
		assertEquals(false, aceptedNameAndDescription);
	}
	
	@Test
	public void testIfReturnsFalseWithIncorrectDescription() {
		InsertProduct includeProduct = new InsertProduct();
		String nameProduct = "Orange";
		
		boolean aceptedNameAndDescription= true;
		try{
			aceptedNameAndDescription = includeProduct.insertProduct(nameProduct);
		}
		catch(Exception e){
			aceptedNameAndDescription = false;
		}
		
		
		assertEquals(false, aceptedNameAndDescription);
	}
	
	
	@Test
	public void testIfReturnsFalseWithIncorrectDescriptionAndName() {
		InsertProduct includeProduct = new InsertProduct();
		String nameProduct = null;
		
		boolean aceptedNameAndDescription= true;
		try{
			aceptedNameAndDescription = includeProduct.insertProduct(nameProduct);
		}
		catch(Exception e){
			aceptedNameAndDescription = false;
		}
		
		
		assertEquals(false, aceptedNameAndDescription);
	}
	
	/*@Test
	public void testCorretUrlInTheCorrectDBConfiguraion() {
		
		DBConfigure dbconfigure = new DBConfigure();
		
		String testeDbConfigure = dbconfigure.getUrl();
		String correctDBConfigure = "jdbc:mysql://localhost:3306/SisCot";
				
		assertEquals(correctDBConfigure, testeDbConfigure);
	}
	
	@Test
	public void testCorretUserInTheCorrectDBConfiguraion() {
		
		DBConfigure dbconfigure = new DBConfigure();
		
		String testeDbConfigure = dbconfigure.getUser();
		String correctDBConfigure = "siscot";
				
		assertEquals(correctDBConfigure, testeDbConfigure);
	}

	@Test
	public void testCorretPasswordInTheCorrectDBConfiguraion() {
		
		DBConfigure dbconfigure = new DBConfigure();
		
		String testeDbConfigure = dbconfigure.getPassword();
		String correctDBConfigure = "12345";
				
		assertEquals(correctDBConfigure, testeDbConfigure);
	}
	
	@Test
	public void testConnectionDBConnect() {
		
		DBConnect dbconnect = new DBConnect();
		
		Connection testeDbConnect = dbconnect.connect();
				
		assertNotNull(testeDbConnect);
		
	}
	*/
}
