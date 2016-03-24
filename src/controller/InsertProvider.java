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
@WebServlet("/IncludeProvider")
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
    
    public boolean insertProvider(Provider provider) {    	
    	boolean wasAdd = false;
    	
    	ProviderDAO providerdao = new ProviderDAO();
    	
    	wasAdd = providerdao.insertProvider(provider);
    	
    	return wasAdd;
    }
}
