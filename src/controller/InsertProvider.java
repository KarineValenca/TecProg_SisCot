/** 
 * File name: InsertProvider.java
 * Purpose of file: This file contains the InsertProvider class and its methods.   
 * Copyright: This software follows GPL license.
 */

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Provider;
import dao.ProviderDAO;

/**
 *Class name: InsertProvider.java
 *Purpose of class: This class is responsible to include a provider.
 */
@WebServlet("/InsertProvider")
public class InsertProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * Method name: InsertProvider
     * Purpose of method: This method is a constructor method of the class. 
     * Responsible to create a new provider.  
     */
    public InsertProvider() {
        super();
    }
    
    /** 
     * Method name: service
     * Purpose of method: This method is used to get some values from view and 
     * pass the result of the method insertProvider to view.  
     * @param request: used to represent the HTTP request that a browser sends
     * to the application.
     * @param response: used to represent the HTTP response that the application
     * sends to a browser.
     */
    protected void service(HttpServletRequest request, 
    					   HttpServletResponse response) throws 
    			   ServletException, IOException {
		assert (request != null) : "The request from client is null";
		assert (response != null) : "The response to client is null";
    	String messageAddConfirmation = "Iniciada";
    	
		//Get atributes of the IncludeProviderView
    	String providerCnpj = request.getParameter("cnpj");
    	String providerName = request.getParameter("name");
    	String providerEmail = request.getParameter("email");
    	String providerPassword = request.getParameter("password");
    	int providerDdd =  Integer.parseInt(request.getParameter("ddd"));
    	int providerPhone = Integer.parseInt(request.getParameter("phone"));
    	String providerAdress = request.getParameter("adress");
    	String providerCity = request.getParameter("city");
    	String providerState = request.getParameter("state");
    	int providerZip = Integer.parseInt(request.getParameter("zip"));
    	boolean authorized = false;
    	
		Provider provider = new Provider();
		    	
    	provider.setProviderCnpj(providerCnpj);
    	provider.setProviderName(providerName);
    	provider.setProviderEmail(providerEmail);
    	provider.setProviderPassword(providerPassword);
    	provider.setProviderDdd(providerDdd);
    	provider.setProviderPhone(providerPhone);
    	provider.setProviderAdress(providerAdress);
    	provider.setProviderCity(providerCity);    	
    	provider.setProviderState(providerState);
    	provider.setProviderZip(providerZip);
    	provider.setAuthorized(authorized);
		    	
		boolean wasAdd = insertProvider(provider);
		
		if (wasAdd) {
			messageAddConfirmation = "Fornecedor Cadastrado com sucesso!";
		}
		else {
			messageAddConfirmation = "Fornecedor não pode ser cadastrado!";
		}
		
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", messageAddConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProviderResponse.jsp");
        rd.forward(request,response);
    }
 
	/** 
     * Method name: insertProvider
     * Purpose of method: This method is add the new provider into the database
     * and verify if the provider was add successfully. 	  
     * @param provider: this object provider to be inserted in the database.
     * @return wasAdd: this boolean value is used to verify if the provider
     * was inserted.
     */	
    public boolean insertProvider(Provider provider) {    	
    	boolean wasAdd = false;
    	
    	ProviderDAO providerdao = new ProviderDAO();	
    	wasAdd = providerdao.insertProvider(provider); 	
    	return wasAdd;
    }
}
