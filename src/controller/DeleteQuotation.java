/**
 * File name: DeleteQuotation.java
 * Purpose of File: This file contains the DeleteQuotation class and its methods.
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

import dao.QuotationDAO;

/*
 * Class name: DeleteQuotation.java
 * Purpose of class: This class is used to delete quotes, and has the method  deleteQuotation.
 */
@WebServlet("/DeleteQuotation")
public class DeleteQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteQuotation() {
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

	/**
	 * Method name: deleteQuotation
	 * Purpose of method: This method is used to delete a quotation from database.
	 * @param quotationId: This attribute uniquely identifies the price
	 * @return: it returns true if the quotation was deleted, and returns false
	 * if the quotation wasn't deleted.
	**/
	public boolean deleteQuotation(int quotationId) {
		assert(quotationId >= 0) : "unexpected error: the quotationId is less than 0";
		boolean wasDeleted = false;
		QuotationDAO quotationDao = new QuotationDAO();

		System.out.println("ID da cotação");
		wasDeleted = quotationDao.deleteQuotation(quotationId);

		return wasDeleted;
	}
}
