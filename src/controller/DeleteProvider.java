package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProviderDAO;

@WebServlet("/DeleteProvider")
public class DeleteProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DeleteProvider() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		String providerName =  request.getParameter("providerName");
		String messageDeletedConfirmation = "Iniciada";
		
		boolean wasDeleted = deleteProvider(providerName);
		
		if(wasDeleted) {
			messageDeletedConfirmation = "Fornecedor Excluído com Sucesso!";
		}
		else {
			messageDeletedConfirmation = "Erro! O fornecedor não pode ser excluído.";
		}
		
		request.setAttribute("mensage", messageDeletedConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProviderResponse.jsp");
	    rd.forward(request,response);
	}
	
	public boolean deleteProvider(String providerName) {
		assert(providerName != null):"The provider name is recieving null";
		boolean wasDeleted = false;
		
		ProviderDAO providerDao = new ProviderDAO();
		System.out.println("Nome do Fornecedor:" + providerName);
		wasDeleted = providerDao.deleteProvider(providerName);
		
		return wasDeleted;
	}

}
