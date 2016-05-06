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
    	String messageAddConfirmation = "Iniciada";
    	
		//Get atributes of the IncludeProviderView
    	String providerCnpj = request.getParameter("cnpj");
    	assert(providerCnpj != null) : "The provider CNPJ is recieving null "
    									+ "from view";
    	String providerName = request.getParameter("name");
    	assert(providerName != null) : "The provider name is recieving null "
    									+ "from view";
    	String providerEmail = request.getParameter("email");
    	assert(providerEmail != null) : "The provider provider email is "
    									+ "recieving null from view";
    	String providerPassword = request.getParameter("password");
    	assert(providerPassword != null) : "The provider provider Password is"
    									   + " recieving null from view";
    	int providerDdd =  Integer.parseInt(request.getParameter("ddd"));
    	assert(providerDdd > 0) : "The provider provider ddd is recieving null"
    							  + " from view";
    	int providerPhone = Integer.parseInt(request.getParameter("phone"));
    	assert(providerPhone > 0) : "The provider provider phone is recieving "
    								+ "null from view";
    	String providerAdress = request.getParameter("adress");
    	assert(providerAdress != null) : "The provider provider adress is "
    									 + "recieving null from view";
    	String providerCity = request.getParameter("city");
    	assert(providerCity != null) : "The provider provider City is recieving"
    									+ " null from view";
    	String providerState = request.getParameter("state");
    	assert(providerState != null) : "The provider provider State is "
    									+ "recieving null from view";
    	int providerZip = Integer.parseInt(request.getParameter("zip"));
    	assert(providerZip > 0) : "The provider provider Zip is recieving null"
    									+ " from view";
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
