/*
 * Class name: SecurityProvider.java
 * Purpose of class: This class is a implementation of Filter interface class.
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

public class SecurityProvider implements Filter {

	// this method is a constructor method of the class.
	public SecurityProvider() {

	}

	// this method is a filter destroy. (Epmty method)
	public void destroy() {

	}

	/*this method is responsible to Verify if the current user have a session 
	setted.*/
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		assert (request != null) : "The request from client is null";
		assert (response != null) : "The response to client is null";
		assert (chain != null) : "The chain to filter implementation is null";
		
		
		// Get the request
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		String url = req.getRequestURL().toString();

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

	// this method set a session.
	private HttpSession setSession(HttpSession session) {
		return null;
	}

	// this method is a filter init. (Epmty method)
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
