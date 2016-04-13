/*
 * Class name: ConsultQuotationManager.java
 * Purpose of class: This class is responsible by consult the list of quotations,
 * it means, that by this class, a manager can see the price of a product at the
 * market.
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

@WebServlet("/ConsultQuotationManager")
public class ConsultQuotationManager extends ConsultQuotation {
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
		
		System.out.println("Tamanho do array: " + quotationList.size());
				
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
