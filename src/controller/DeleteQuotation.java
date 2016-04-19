package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuotationDAO;

@WebServlet("/DeleteQuotation")
public class DeleteQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteQuotation() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		int quotationId = Integer.parseInt(request.getParameter("quotationId"));
		String messageDeletedConfirmation = "Iniciada";

		boolean wasDeleted = deleteQuotation(quotationId);

		if(wasDeleted) {
			messageDeletedConfirmation = "Cotação excluída com sucesso!";
		}
		else {
			messageDeletedConfirmation = "Erro! A cotação não pôde ser excluída.";
		}

		request.setAttribute("mensage", messageDeletedConfirmation);

		//Dispacher the result from the view of confirmation
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/QuotationResponse.jsp");
	    rd.forward(request,response);
	}

	public boolean deleteQuotation(int quotationId) {
		assert(quotationId >= 0) : "unexpected error: the quotationId is less than 0";
		boolean wasDeleted = false;
		QuotationDAO quotationDao = new QuotationDAO();

		System.out.println("ID da cotação");
		wasDeleted = quotationDao.deleteQuotation(quotationId);

		return wasDeleted;
	}

}
