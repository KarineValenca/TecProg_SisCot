/**
* File name: login.java 
* Purpose of file: This class has the methods used to authenticate a user at the system.
* Copyright: This software follows GPL license.
**/

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
 * Class name: Login
 * Purpose of class: This class has implementation the methods used to authenticate 
 * a user at the system.
 **/
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* Method name: service
	* Purpose of method: This method get the session and finalize that. Verify
	* if the login and password is authorized, if it is not authorized, 
	* redirect to error page.
	* @param request: used to represent the HTTP request that a browser sends
    * to the application.
	* @param response: used to represent the HTTP response that the application
    * sends to a browser.  
	* @return: there is no return.
	**/
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = request.getParameter("login");
		assert (username != null) : "unexpected error: the user name is recieving null from view";
		String password = request.getParameter("password");
		assert (password != null) : "unexpected error: the password is recieving null from view";
		username = username.trim();
		session = loginChecks(username, password, session);
		String url = null;
		if (session != null) {
			url = "/index.jsp";
			dispatcher(request, response, url);
		} else {
			url = "/error.jsp";
			dispatcher(request, response, url);
		}
	}
	
	/**
	* Method name: loginChecks
	* Purpose of method: This method checks if the user and password are correct
	* to authenticate the system.
	* @param username: user name is used to authenticate a user at system. 
	* @param password: password of a user and it is used to authenticate a user 
	* at system. 
	* @param session: session of user.
	* @return session: a session null if the user isn't registered. And returns 
	* a pair of attributes setted if the login is correct.
	**/
	HttpSession loginChecks(String username, String password, HttpSession session) {

		ProviderDAO providerDAO = new ProviderDAO();
		ArrayList<Provider> listProviders = new ArrayList<Provider>();
		listProviders = providerDAO.listProviders();

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

		ManagerDAO managerDAO = new ManagerDAO();
		ArrayList<Manager> listManagers = new ArrayList<Manager>();
		listManagers = managerDAO.listManagers();

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
	* Method name: updateSessionProvider
	* Purpose of method: This method is responsible for update of the 
	* current session provider data.
	* @param session: session of user.
	* @param session: object provider.
	* @return: There is no return.
	**/
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
	* Method name: dispatcher
	* Purpose of method: This method is responsible to make the targeting of urls.
	* @param request: used to represent the HTTP request that a browser sends
    * to the application.
	* @param response: used to represent the HTTP response that the application
    * sends to a browser.
	* @param url: Directs the user to a page.
	* @return: There is no return.
	**/
	public void dispatcher(HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {

		RequestDispatcher rd;
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	* Method name: dispatcher
	* Purpose of method: This method is responsible to retrieve the user.
	* @param request: used to represent the HTTP request that a browser sends
    * to the application.
	* @param response: used to represent the HTTP response that the application
	* @return providerName: provider name.
	**/
	public static String getProviderNameFromSession(HttpServletRequest request, 
			HttpServletResponse response)
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
