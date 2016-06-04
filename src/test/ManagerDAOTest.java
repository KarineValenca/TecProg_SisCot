package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import junit.framework.TestCase;

import dao.ManagerDAO;

import model.Manager;

public class ManagerDAOTest extends TestCase {

	Manager manager = new Manager();
	ManagerDAO managerDao = new ManagerDAO();
	ResultSet rs;
	PreparedStatement statement;
	ArrayList<Manager> managers = new ArrayList<Manager>();
	int i;
	
	@Test
	public void testInsertManager() {	
		manager.setManagerUsername("gerente");
		manager.setManagerPassword("senha123");
		
		assertEquals(true, managerDao.insertManager(manager));		
	}

	@Test
	public void testListManagers() throws SQLException {		
		managers = managerDao.listManagers();
		
		assertEquals(false, managers.isEmpty());
	}
	
	@Test
	public void testListManagersComparingValues() throws SQLException {		
		manager.setManagerUsername("gerente2");
		manager.setManagerPassword("senhanov");

		managerDao.insertManager(manager);
		
		managers = managerDao.listManagers();
		
		boolean managerExists = false;
		
		for(i = 0; i < managers.size(); i++) {
			managerExists = managers.get(i).getManagerUsername().equals("gerente2");
		}
		
		assertTrue(managerExists);
	}
	
	@Test
	public void testDeleteManager() throws SQLException {
		manager.setManagerUsername("RemoverGerente");
		manager.setManagerPassword("remover");
		
		managerDao.insertManager(manager);
		
		assertTrue(managerDao.deleteManager("RemoverGerente"));
	}
	
	@Test
	public void testDeleteManagerSearchingForTheManager() throws SQLException {
		manager.setManagerUsername("RemoverGerente2");
		manager.setManagerPassword("remover2");
		
		managerDao.insertManager(manager);
		managerDao.deleteManager("RemoverGerente2");
		
		managers = managerDao.listManagers();
		boolean managerExists = false;
		
		for(i = 0; i < managers.size(); i++) {
			managerExists = managers.get(i).getManagerUsername().equals("RemoverGerente2");
		}
		
		assertFalse(managerExists);
	}
	
	@Test
	public void testUpdateManager() throws SQLException {
		manager.setManagerUsername("UpdateManager");
		manager.setManagerPassword("atualiza");
		
		managerDao.insertManager(manager);
		
		manager.setManagerUsername("ManUpdated");
		manager.setManagerPassword("update");
		
		assertTrue(managerDao.updateManager("ManUpdated", manager));
	}
	
	@Test
	public void testUpdateManagerSearchingForTheNewUsername() throws SQLException {
		manager.setManagerUsername("GerenteSuperior");
		manager.setManagerPassword("superior");
		
		managerDao.insertManager(manager);
		
		manager.setManagerUsername("Admin");
		manager.setManagerPassword("updated");
		managerDao.updateManager("GerenteSuperior", manager);
		
		managers = managerDao.listManagers();
		boolean managerUpdated = false;
		
		for(i = 0; i < managers.size(); i++) {
			managerUpdated = managers.get(i).getManagerUsername().equals("Admin");
		}
		
		assertTrue(managerUpdated);
	}
}
