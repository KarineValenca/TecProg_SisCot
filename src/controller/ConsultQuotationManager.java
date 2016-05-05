/**
 * File name: ConsultQuotationManager.java 
 * Purpose of file: This file contains the ConsultQuotationManager class and 
 * its methods.
 * Copyright: This software follows GPL license.
 **/

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Quotation;
import dao.QuotationDAO;

/*
 * Class name: ConsultQuotationManager
 * Purpose of class: This class is responsible by consult the list of quotations,
 * it means, that by this class, a manager can see the price of a product at the
 * market.
 */
@WebServlet("/ConsultQuotationManager")
public class ConsultQuotationManager extends ConsultQuotation {
	private static final long serialVersionUID = 1L;

	/**
	 * Method name: service
	 * Purpose of method: This method is used to get the values of the view
	 * and call the method buildQuotationList.
	 * @param request: this attribute is used to represent the HTTP request 
	 * that a browser sends to the application. 
	 * @param response: this attribute is used to represent the HTTP response
	 * that the application sends to a browser.
	 * @return: there is no return.
	**/
	@Override
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		
		quotationList = buildQuotationList();
		
		request.setAttribute("quotationList", quotationList);
		
		System.out.println("Tamanho do array: " + quotationList.size());
				
		RequestDispatcher rd;
		
		rd = request.getRequestDispatcher("/ConsultQuotationList.jsp");
        rd.forward(request,response);
	}

	/**
	 * Method name: service
	 * Purpose of method: This method is used to consult the list of quotations
	 * related to a manager in the database.
	 * @param: there is no param.
	 * @return: it return an arraylist of quotation type with all quotations 
	 * related to a manager.
	**/
	@Override
	protected ArrayList<Quotation> buildQuotationList() {
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		QuotationDAO quotationdao = new QuotationDAO();
		
		quotationList = quotationdao.listQuotation();
		
		return quotationList;
	}
}
