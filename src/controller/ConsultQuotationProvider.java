/*
 * Class name: ConsultQuotationProvider.java
 * Purpose of class: This class is used by the provider to consult the list of 
 * quotations, it means a provider can see the price of a product that he offers.
 * Copyright: This software follows GPL license.
 */

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

@WebServlet("/ConsultQuotationProvider")
public class ConsultQuotationProvider extends ConsultQuotation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		
		quotationList = buildQuotationList();
		
		request.setAttribute("quotationList", quotationList);
				
		RequestDispatcher rd;
		
		rd = request.getRequestDispatcher("/ConsultQuotationList.jsp");
        rd.forward(request,response);
	}

	@Override
	protected ArrayList<Quotation> buildQuotationList() {
		ArrayList<Quotation> quotationList = new ArrayList<Quotation>();
		QuotationDAO quotationdao = new QuotationDAO();
		
		quotationList = quotationdao.listQuotation();
		
		return quotationList;
	}

}
