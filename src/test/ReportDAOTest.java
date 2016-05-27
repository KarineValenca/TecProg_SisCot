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
		
		assertEquals(Arrays.asList("Arroz"), reportDAO.listProductsManager(1));
	}

}
