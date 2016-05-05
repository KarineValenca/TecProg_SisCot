/**
 * File name: ConsultProvider.java 
 * Purpose of file: This file contains the ConsultProvider class and its methods.
 * Copyright: This software follows GPL license.
 **/

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProviderDAO;
import model.Provider;

/**
* Class name: ConsultProvider
* Purpose of class: This class is used to do a consult at providers data, and 
* list all providers.
**/
@WebServlet("/ConsultProvider")
public class ConsultProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ConsultProvider() {
        super();
    }
    
    /**
	 * Method name: service
	 * Purpose of method: By this method a consult at database is done and the 
	 * providers list is obtained.
	 * @param request: this attribute is used to represent the HTTP request 
	 * that a browser sends to the application. 
	 * @param response: this attribute is used to represent the HTTP response
	 * that the application sends to a browser.
	 * @return: there is no return.
	 **/
    protected void service(HttpServletRequest request, 
    						HttpServletResponse response) 
    						throws ServletException, IOException {
    	ArrayList<Provider> providerList = new ArrayList<Provider>();
    	ProviderDAO providerDao = new ProviderDAO();
    	
    	providerList = providerDao.listProviders();
    	request.setAttribute("providers", providerList);
    	
    	RequestDispatcher rd;
    	
		rd = request.getRequestDispatcher("/ConsultProviderList.jsp");
        rd.forward(request,response);
    }
}
