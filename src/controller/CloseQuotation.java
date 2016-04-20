/*
 * Class name: CloseQuotation.java
 * Purpose of class: This class is used to close quotations, accepted.
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

import dao.QuotationDAO;

/**
 * Servlet implementation class CloseQuotation
 */
@WebServlet("/CloseQuotation")
public class CloseQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

            /**
             * @see HttpServlet#HttpServlet()
             */
            public CloseQuotation() {
                super();
            }

            	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quotationId = request.getParameter("quotationId");
		int integerQuotationID = Integer.parseInt(quotationId);

		QuotationDAO quotationdao = new QuotationDAO();
		quotationdao.updateQuotation(integerQuotationID);

		RequestDispatcher rd;
		rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
