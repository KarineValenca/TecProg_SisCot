package resouces;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManagerDAO;
import dao.ProviderDAO;
import model.Manager;
import model.Provider;
import model.Report;
import model.ReportManager;
import model.ReportProvider;

/**
 * Servlet implementation class Login
 * 
 * @author tiago
 * @version 1.0
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Session utilized for stores the data of users
		HttpSession session = request.getSession();

		// Get the data of user and verify if is a stored user
		String username = request.getParameter("login");
		assert (username != null) : "unexpected error: the user name is recieving null from view";
		String password = request.getParameter("password");
		assert (password != null) : "unexpected error: the password is recieving null from view";
		username = username.trim();

		session = loginChecks(username, password, session);

		String url = null;

		// Dispatcher a url as user
		if (session != null) {
			url = "/index.jsp";
			dispatcher(request, response, url);
		} else {
			url = "/error.jsp";
			dispatcher(request, response, url);
		}
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return A session null if the user isn't registered. And returns a pair
	 *         of attributs setted if the login is correct
	 */
	HttpSession loginChecks(String username, String password, HttpSession session) {

		// Get all user from listProviders
		ProviderDAO providerDAO = new ProviderDAO();
		ArrayList<Provider> listProviders = new ArrayList<Provider>();
		listProviders = providerDAO.listProviders();

		// Search a correct user and password
		for (Provider provider : listProviders) {
			boolean isUser = provider.getProviderEmail().equals(username);
			boolean correctPassword = provider.getProviderPassword().equals(password);

			if (isUser && correctPassword) {

				session = updateSessionProvider(session, provider);

				return session;
			} else {
				session.setAttribute("user", null);
				session.setAttribute("userType", null);
			}
		}

		// Get all user from listManagers
		ManagerDAO managerDAO = new ManagerDAO();
		ArrayList<Manager> listManagers = new ArrayList<Manager>();
		listManagers = managerDAO.listManagers();

		// Search a correct user and password
		for (Manager manager : listManagers) {
			boolean isUser = manager.getManagerUsername().equals(username);
			boolean correctPassword = manager.getManagerPassword().equals(password);

			if (isUser && correctPassword) {

				session.setAttribute("user", manager.getManagerUsername());
				session.setAttribute("userType", "manager");
				return session;
			} else {
				session.setAttribute("user", null);
				session.setAttribute("userType", null);
			}
		}

		return session;
	}

	/**
	 * Update the data of current provider
	 * 
	 * @param session
	 * @param provider
	 * @return
	 */
	public HttpSession updateSessionProvider(HttpSession session, Provider provider) {
		session.setAttribute("user", provider.getProviderName());
		session.setAttribute("providerCnpj", provider.getProviderCnpj());
		session.setAttribute("providerEmail", provider.getProviderEmail());
		session.setAttribute("providerDdd", provider.getProviderDdd());
		session.setAttribute("providerPassword", provider.getProviderPassword());
		session.setAttribute("providerPhone", provider.getProviderPhone());
		session.setAttribute("providerState", provider.getProviderState());
		session.setAttribute("providerCity", provider.getProviderCity());
		session.setAttribute("providerAdress", provider.getProviderAdress());
		session.setAttribute("providerZip", provider.getProviderZip());

		String authorized = null;
		System.out.println("Banco autenticado: " + provider.isAuthorized());
		if (provider.isAuthorized()) {
			System.out.println("Cheio");
		} else {
			authorized = "";
		}

		session.setAttribute("authorized", authorized);

		session.setAttribute("userType", "provider");
		return session;
	}

	/**
	 * Make a dispatcher for all methods with a url
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 */
	public void dispatcher(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {

		RequestDispatcher rd;
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	public static String getProviderNameFromSession(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the request
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String providerName;

		if (session.getAttribute("user") != null) {
			if(session.getAttribute("userType").equals("provider"))
				providerName = (String) session.getAttribute("user");
			else
				providerName = null;
		}
		else {
			providerName = null;
		}
		
		return providerName;
	}

}
