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
 * Servlet Filter implementation class SecurityProvider
 * 
 * @author tiago
 * @version 1.0
 */
@WebFilter(urlPatterns = {"*.jsp", "*.html", "/ConsultProduct",
		"/ConsultProvider", "/DeleteProduct", "/DeleteProvider",
		"/IncludeProduct", "/IncludeProvider", "/UpdateProduct",
		"/UpdateProvider"})
public class SecurityProvider implements Filter {

	/**
	 * Default constructor.
	 */
	public SecurityProvider() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
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

	private HttpSession setSession(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
