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
 * @author tiago
 * Servlet implementation class IncludeProvider
 */
@WebServlet("/InsertProvider")
public class InsertProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Creating new Provider
     * @see HttpServlet#HttpServlet()
     */
    public InsertProvider() {
        super();
    }
    
    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws 
    	ServletException, IOException {
    	String messageAddConfirmation = "Iniciada";
    	
		//Get atributes of the IncludeProviderView
    	String providerCnpj = request.getParameter("cnpj");
    	assert(providerCnpj != null) : "The provider CNPJ is recieving null from view";
    	String providerName = request.getParameter("name");
    	assert(providerName != null) : "The provider name is recieving null from view";
    	String providerEmail = request.getParameter("email");
    	assert(providerEmail != null) : "The provider provider email is recieving null from view";
    	String providerPassword = request.getParameter("password");
    	assert(providerPassword != null) : "The provider provider Password is recieving null from view";
    	int providerDdd =  Integer.parseInt(request.getParameter("ddd"));
    	assert(providerDdd > 0) : "The provider provider ddd is recieving null from view";
    	int providerPhone = Integer.parseInt(request.getParameter("phone"));
    	assert(providerPhone > 0) : "The provider provider phone is recieving null from view";
    	String providerAdress = request.getParameter("adress");
    	assert(providerAdress != null) : "The provider provider adress is recieving null from view";
    	String providerCity = request.getParameter("city");
    	assert(providerCity != null) : "The provider provider City is recieving null from view";
    	String providerState = request.getParameter("state");
    	assert(providerState != null) : "The provider provider State is recieving null from view";
    	int providerZip = Integer.parseInt(request.getParameter("zip"));
    	assert(providerZip > 0) : "The provider provider Zip is recieving null from view";
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
    
    public boolean insertProvider(Provider provider) {    	
    	boolean wasAdd = false;
    	
    	ProviderDAO providerdao = new ProviderDAO();
    	
    	wasAdd = providerdao.insertProvider(provider);
    	
    	return wasAdd;
    }
}
