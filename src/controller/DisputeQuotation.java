/*
 * File name: DisputeQuotation.java
 * Purpose of file: This file is composed by DisputeQuotation class and methods.
 * Copyright: This software follows GPL license.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuotationDAO;
import resouces.Login;

/*
 * Class name: DisputeQuotation
 * Purpose of class: This class is responsible for create a dispute quotation 
 * and, using the RequestDispatcher objetc, acess the index views pages.
 */
public class DisputeQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * Method name: DisputeQuotation
	 * Purpose of method: This method is a constructor method of the class. 
	 */
    public DisputeQuotation() {
        super();
    }

    /**
     * Method name: service
     * Purpose of method: This method is responsible for get the provider name,
     * the quotation id and create products and price products list.
     * @param request Represent the HTTP request that a browser sends to the application.
     * @param response Represent the HTTP response that the application sends to a browser.
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		assert (request != null) : "The request from client is null";
		assert (response != null) : "The response to client is null";
		
		Enumeration<String> teste = request.getParameterNames();
		ArrayList<String> products = new ArrayList<String>();
		ArrayList<Double> priceOfProducts = new ArrayList<Double>();
		
		String providerName= Login.getProviderNameFromSession(request, response);
		System.out.println("Nome do provider vindo de Login " + providerName);
		
		String quotationId = request.getParameter("insert");
		int integerQuotationId = Integer.parseInt(quotationId);
				
		
		String priceOfProduct = null;
		String currentProduct = null;
		Double currentProductValue;
		
		
		System.out.println("Quotaion ID " + request.getParameter("insert"));
		 
		
		while(teste.hasMoreElements()){
			currentProduct = teste.nextElement();
			
			if(!currentProduct.equals("insert")){
				priceOfProduct = request.getParameter(currentProduct);
				currentProductValue = Double.parseDouble(priceOfProduct);
				
				products.add(currentProduct);
				priceOfProducts.add(currentProductValue);
			}
			else {
				//nothing to do
			}
		}
		
		QuotationDAO quotationdao = new QuotationDAO();
		quotationdao.updateQuotationPrices(products, priceOfProducts, integerQuotationId, providerName);
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
