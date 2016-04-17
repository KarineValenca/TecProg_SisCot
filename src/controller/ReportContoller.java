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
 * Servlet implementation class Report
 */
@WebServlet("/Report")
public class ReportContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportContoller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		assert (request != null) : "The request from client is null";
		assert (response != null) : "The response to client is null";
		
		sendQuotation(request, response);
	}
	
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
		
		int sizeOfProductsForProvider = productsForProvider.get(2).size();
		
		for(int i = 0; i < sizeOfProductsForProvider; ++i){
			
			ArrayList<Double> listPrice = productsForProvider.get(2);
			
			Double priceProduct = (Double)listPrice.get(i);
			
			String priceDecimalFormatAsString = Calculations.formatDecimal(priceProduct);
			
			priceAsString.add(priceDecimalFormatAsString);
			
		}
		
		request.setAttribute("listProducts", productsForProvider.get(0));
		request.setAttribute("listProviders", productsForProvider.get(1));
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

	private boolean verifyStateQuotation(HttpServletRequest request) {
		assert(request != null) : "The request from client is null";
		
		String quotationIsOn = request.getParameter("isOn");
		
		boolean quotationIsOnBool = Boolean.parseBoolean(quotationIsOn);
		
		return quotationIsOnBool;
	}

	private int getQuotationID(HttpServletRequest request) {
		assert(request != null) : "The request from client is null";
		
		String quotationId = request.getParameter("quotationId");
		
		int integerQuotationID = Integer.parseInt(quotationId);

		return integerQuotationID;
	}

	private Quotation getQuotation(int integerQuotationID) {
		assert(integerQuotationID != 0) : "the quotationID variable receive 0";
		QuotationDAO quotationdao = new QuotationDAO();
		Quotation quotation = new Quotation();
		quotation = quotationdao.selectQuotationByID(integerQuotationID);

		return quotation;
	}
}
