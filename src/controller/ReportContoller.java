/**
 * File name: ReportController.java
 * Purpose of file: This is method is composed by ReportController class and 
 * methods.
 * Copyright: This software follows GPL license.
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuotationDAO;
import model.Product;
import model.Quotation;
import model.Report;
import model.ReportManager;
import model.ReportProvider;
import resouces.Calculations;

/**
 * Class name: ReportController
 * Purpose of class: This class creates a report according to the user type and
 * status quotation.
 */
public class ReportContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Method name: ReportContoller
	 * Purpose of method: This method is a constructor method of the class
	 */
	public ReportContoller() {
		super();
	}

	/**
	 * Method name: service
	 * Purpose of method: This method call the sendQuotation method.
	 * @param request Represent the HTTP request that a browser sends to the application.
	 * @param response Represent the HTTP response that the application sends to a browser.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert (request != null) : "The request from client is null";
		assert (response != null) : "The response to client is null";
		
		sendQuotation(request, response);
	}
	
	/**
	 * Method name: sendQuotation
	 * Purpose of method: this method creates a products list in quotation; 
	 * creates a report according to the user type and status quotation; 
	 * creates a prices list; request the view pages according to status 
	 * quotation.
	 * @param request Represent the HTTP request that a browser sends to the application.
	 * @param response Represent the HTTP response that the application sends to a browser.
	 */
	void sendQuotation(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int quotationID = getQuotationID(request);
		
		boolean quotationIsOn = verifyStateQuotation(request);

		// Create a quotation with ID
		Quotation quotation = new Quotation();
		quotation = getQuotation(quotationID);

		ArrayList<Product> products = new ArrayList<>();
		QuotationDAO quotationdao = new QuotationDAO();

		products = quotationdao.getListProductsInAQuotation(quotationID);

		// Get the request
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();

		Report report = new Report();
		
		String attributeUser = (String) session.getAttribute("user");
		
		if (attributeUser != null) {
			String userType = (String) session.getAttribute("userType");

			if (userType.equals("manager")) {
				report = new ReportManager(products, quotation, 0.0);
			} 
			else if (userType.equals("provider") && !quotationIsOn) {
				String providerName = (String) session.getAttribute("user");
				report = new ReportProvider(products, quotation, 0.0, providerName);
			}
			else if (userType.equals("provider") && quotationIsOn){
				report = new ReportManager(products, quotation, 0.0);
			}
		}
		else {
			//nothing to do
		}

		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		productsForProvider = report.showProducts();
		
		ArrayList<String> priceAsString = new ArrayList<>();
		
		ArrayList<ArrayList> productsForProviderIndex = productsForProvider.get(2);
		Integer productsForProviderIndexSize = productsForProviderIndex.size();
		int sizeOfProductsForProvider = productsForProviderIndexSize;
		
		for(int i = 0; i < sizeOfProductsForProvider; ++i){
			
			ArrayList<Double> listPrice = productsForProvider.get(2);
			
			Double priceProduct = (Double)listPrice.get(i);
			
			String priceDecimalFormatAsString = Calculations.formatDecimal(priceProduct);
			
			priceAsString.add(priceDecimalFormatAsString);
			
		}
		
		ArrayList<Double> indexZeroOfProductsForProvider = productsForProvider.get(0);
		request.setAttribute("listProducts", indexZeroOfProductsForProvider);
		
		ArrayList<Double> indexOneOfProductsForProvider = productsForProvider.get(1);
		request.setAttribute("listProviders", indexOneOfProductsForProvider);
		
		request.setAttribute("listPrices", priceAsString);
		
		// Dispacher the result from the view of confirmation		
		String urlToSend = null;
		
		
		if (quotationIsOn) {
			urlToSend = "/DisputeQuotation.jsp";
		}
		else {
			urlToSend = "/ShowReport.jsp";
		}
		
		System.out.println("PAssou pagian: " + urlToSend);
		
		RequestDispatcher rd = request.getRequestDispatcher(urlToSend);
		rd.forward(request, response);
	}

	/**
	 * Method name: verifyStateQuotation 
	 * Purpose of method: This method aims to verify the state quotation. 
	 * @param request Represent the HTTP request that a browser sends to the application.
	 * @return quotationIsOnBool Boolean representing the state quotation.
	 */
	private boolean verifyStateQuotation(HttpServletRequest request) {
		assert(request != null) : "The request from client is null";
		
		String quotationIsOn = request.getParameter("isOn");
		
		boolean quotationIsOnBool = Boolean.parseBoolean(quotationIsOn);
		
		return quotationIsOnBool;
	}

	/**
	 * Method name: getQuotationID
	 * Purpose of method: This method gets the quotation id in a string format
	 * and turns it in a integer type.
	 * @param request Represent the HTTP request that a browser sends to the application.
	 * @return integerQuotationID This attribute is a quotation id in a integer format. 
	 */
	private int getQuotationID(HttpServletRequest request) {
		assert(request != null) : "The request from client is null";
		
		String quotationId = request.getParameter("quotationId");
		
		int integerQuotationID = Integer.parseInt(quotationId);

		return integerQuotationID;
	}

	/**
	 * Method name: getQuotation
	 * Purpose of method: This method crates a new quotation into the database.
	 * @param integerQuotationID
	 * @return quotation Used to call the selectQuotationByID.
	 */
	private Quotation getQuotation(int integerQuotationID) {
		assert(integerQuotationID != 0) : "the quotationID variable receive 0";
		QuotationDAO quotationdao = new QuotationDAO();
		Quotation quotation = new Quotation();
		quotation = quotationdao.selectQuotationByID(integerQuotationID);

		return quotation;
	}
}
