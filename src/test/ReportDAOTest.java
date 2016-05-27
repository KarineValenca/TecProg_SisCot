package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import dao.ProductDAO;
import dao.ReportDAO;
import model.Product;

public class ReportDAOTest {

	@Test
	public void testListProductsManagers() {
		ReportDAO reportDAO = new ReportDAO();
		ArrayList<String> productsManager = new ArrayList<String>();
		
		productsManager = reportDAO.listProductsManager(1);
		
		assertEquals(Arrays.asList("Arroz"), productsManager);
	}
	
	@Test
	public void testProvidersManager() {
		ReportDAO reportDAO = new ReportDAO();
		ArrayList<String> providersManager = new ArrayList<String>();
		
		providersManager = reportDAO.listProvidersManager(1);
		
		assertEquals(Arrays.asList("Produto não possui fornecedor!"), providersManager);
	}

}
