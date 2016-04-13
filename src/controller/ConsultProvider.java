/*
 * Class name: ConsultProvider.java
 * Purpose of class: This class is used to do a consult at providers data, and list all providers.
 * Copyright: This software follows GPL license.
 */

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
 * Servlet implementation class ConsultProvider
 */

@WebServlet("/ConsultProvider")
public class ConsultProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultProvider() {
        super();
    }
    
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
