/**
 * File name: UpdateProvider.java 
 * Purpose of file: This file contains the UpdateProvider class and its methods.
 * Copyright: This software follows GPL license.
 **/

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Provider;
import resouces.Login;
import dao.ProviderDAO;

/**
 * Class name: UpdateProvider
 * Purpose of class: This class is used to update a provider at database.
 **/
@WebServlet("/UpdateProvider")
public class UpdateProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UpdateProvider() {
		super();
	}
	
	/**
	 * Method name: service
	 * Purpose of method:  This method is used to get some values from view and 
	 * pass the result of the method updateProvider to view.
	 * @param request: this attribute is used to represent the HTTP request 
	 * that a browser sends to the application. 
	 * @param response: this attribute is used to represent the HTTP response
	 * that the application sends to a browser.
	 * @return: there is no return.
	**/
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		String messageUpdateConfirmation = "Iniciada";
		boolean wasUpdated = sendToProviderDAO(request);
		
		if(wasUpdated) {
			messageUpdateConfirmation = "Fornecedor atualizado com sucesso!";
		}
		else {
			messageUpdateConfirmation = "Fornecedor não foi atualizado!";
		}
		
		request.setAttribute("mensage", messageUpdateConfirmation);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProviderResponse.jsp");
        rd.forward(request,response);
	}
	
	/**
	 * Method name: sendToProviderDAO
	 * Purpose of method: This method is used to get the actual provider and its
	 * attributes, and pass the view values to the provider object.
	 * @param request: this attribute is used to represent the HTTP request that
	 *  a browser sends to the application
	 * @return: it returns true if the provider was updated, and returns false
	 * if the provider wasn't updated.
	**/
	public boolean sendToProviderDAO(HttpServletRequest request) {
		boolean wasUpdated = false;			
		Provider provider = new Provider();
		
		provider.setProviderCnpj(request.getParameter("cnpj"));
		provider.setProviderName(request.getParameter("name"));
		provider.setProviderEmail(request.getParameter("email"));
		provider.setProviderPassword(request.getParameter("password"));
		provider.setProviderDdd(Integer.parseInt(request.getParameter("ddd")));
		provider.setProviderPhone(Integer.parseInt(request.getParameter("phone")));
		provider.setProviderAdress(request.getParameter("adress"));
		provider.setProviderCity(request.getParameter("city"));
		provider.setProviderState(request.getParameter("state"));
		provider.setProviderZip(Integer.parseInt(request.getParameter("zip")));
		provider.setAuthorized(request.getParameter("authorized") != null);
		
		HttpSession session = request.getSession();
		Login login = new Login();
		
		session = login.updateSessionProvider(session, provider);
		
		ProviderDAO providerDAO = new ProviderDAO();
		String actualProviderCnpj = request.getParameter("actualCnpj");
		assert(actualProviderCnpj != null) : "the actual provider cnpj is "
				+ "recieving null from view";
		
		wasUpdated = providerDAO.updateProvider(actualProviderCnpj, provider);
		
		return wasUpdated;
	}
}