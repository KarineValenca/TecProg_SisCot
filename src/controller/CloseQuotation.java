/**
 * File name: CloseQuotation.java
 * Purpose of File: This file contains the CloseQuotation class and its methods.
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
 * Class name: CloseQuotation
 * Purpose of class: Servlet implementation class CloseQuotation
 */
@WebServlet("/CloseQuotation")
public class CloseQuotation extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
	    public CloseQuotation() {
	        super();
	    }
		
		/**
		* Method name: service
		* Purpose of method: By this method a consult at database is done and the
		* providers list is obtained.
		* @param request: this attribute is used to represent the HTTP request
		* that a browser sends to the application.
		* @param response: this attribute is used to represent the HTTP response
		* that the application sends to a browser.
		* @return: there is no return.
		*/
		protected void service(HttpServletRequest request, HttpServletResponse response) 
							   throws ServletException, IOException {
			String quotationId = request.getParameter("quotationId");
			int integerQuotationID = Integer.parseInt(quotationId);
			
			QuotationDAO quotationdao = new QuotationDAO();
			quotationdao.updateQuotation(integerQuotationID);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");;
			rd.forward(request, response);
		}
}
