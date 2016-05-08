/**
 * File name: SecurityProvider.java
 * Purpose of file: This file is composed by SecurityProvider class and methods.
 * Copyright: This software follows GPL license.
 */
package resouces;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Class name: SecurityProvider
 * Purpose of class: This class is a implementation of Filter interface class.
 */
public class SecurityProvider implements Filter {

	/**
	 * Method name: SecurityProvider
	 * Purpose of method: This method is a constructor method of the class.
	 */
	public SecurityProvider() {

	}
	
	/**
	 * Method name: destroy
	 * Purpose of method: This method is a filter destroy. (Epmty method)
	 */
	public void destroy() {

	}

	/**
	 * Method name: doFilter
	 * Purpose of method: This method is responsible to Verify if the current 
	 * user have a session setted.
	 * @param Represent the HTTP request that a browser sends to the 
	 * application.
	 * @param Represent the HTTP response that the application sends to a 
	 * browser.
	 * @param chain FilterChain object instance. 
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		assert (request != null) : "The request from client is null";
		assert (response != null) : "The response to client is null";
		assert (chain != null) : "The chain to filter implementation is null";
		
		
		// Get the request
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		StringBuffer requestURL = req.getRequestURL();
		String requestURLString = requestURL.toString();
		String url = requestURLString;

		String attributeUser = (String) session.getAttribute("user"); 
		boolean isSession = (attributeUser != null);
		
		boolean requestIsIndex = (url.equals("http://localhost:8080/SisCot/"));

		// Verify if the current user have a session setted
		if (isSession || requestIsIndex) {
			session = setSession(session);
			chain.doFilter(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}
	
	/**
	 * Method name: setSession
	 * Purpose of method: This method set a session.
	 * @param session Call the req.getSession method.
	 * @return null Returns a null value session.
	 */
	private HttpSession setSession(HttpSession session) {
		return null;
	}
	
	/**
	 * Method name: init
	 * Purpose of method: This method is a filter init. (Epmty method)
	 * @param fConfig FilterConfig object instance.
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
