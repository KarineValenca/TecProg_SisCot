/**
 * File name: DeleteProvider.java 
 * Purpose of file: This file contains the DeleteProvider class and its methods.
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

import dao.ProviderDAO;

/**
 * Class name: DeleteProvider
 * Purpose of class: This class is used to exclude a provider from database.
 **/
@WebServlet("/DeleteProvider")
public class DeleteProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DeleteProvider() {
		super();
	}
	
	/**
	 * Method name: service
	 * Purpose of method: This method is used to get some values from view and 
	 * pass the result of the method deleteProvider to view.
	 * @param request: this attribute is used to represent the HTTP request 
	 * that a browser sends to the application. 
	 * @param response: this attribute is used to represent the HTTP response
	 * that the application sends to a browser.
	 * @return: there is no return.
	**/
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		String providerName =  request.getParameter("providerName");
		
		assert(providerName != null) : "The providerName is recieving null from view";
		
		String messageDeletedConfirmation = "Iniciada";
		
		boolean wasDeleted = deleteProvider(providerName);
		
		if(wasDeleted) {
			messageDeletedConfirmation = "Fornecedor Excluído com Sucesso!";
		}
		else {
			messageDeletedConfirmation = "Erro! O fornecedor não pode ser excluído.";
		}
		
		request.setAttribute("mensage", messageDeletedConfirmation);
		
		//Dispatcher the result from the view of confirmation		
		RequestDispatcher rd;
		
		rd = request.getRequestDispatcher("/ProviderResponse.jsp");
	    rd.forward(request,response);
	}
	
	/**
	 * Method name: deleteProvider
	 * Purpose of method: This method is used to delete a provider from database.
	 * @param providerName: this attribute is the name of the provider that will
	 * be deleted.
	 * @return: it returns true if the provider was deleted, and returns false
	 * if the provider wasn't deleted.
	**/
	public boolean deleteProvider(String providerName) {
		assert(providerName != null) : "The provider name is recieving null";
		
		boolean wasDeleted = false;
		ProviderDAO providerDao = new ProviderDAO();
		
		wasDeleted = providerDao.deleteProvider(providerName);
		
		return wasDeleted;
	}

}
