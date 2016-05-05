/**
* File name: logout.java 
* Purpose of file: This class has the methods used to logout a user at the system.
* Copyright: This software follows GPL license.
**/

package resouces;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* Class name: Logout
* Purpose of class: This class is responsible for defines the logout 
* a user at the system.
**/

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Logout() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the session and finalize that
		HttpSession session = request.getSession();
    	session.invalidate();
    	
    	//Dispatcher a user to index file
    	RequestDispatcher rd;
		rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
	}

}
