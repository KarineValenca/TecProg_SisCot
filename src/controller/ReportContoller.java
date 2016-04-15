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
		
		sendQuotation(request, response);
	}
	
	void sendQuotation(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		int quotationID;
		quotationID = getQuotationID(request);
		
		boolean quotationIsOn;
		quotationIsOn = verifyStateQuotation(request);

		// Create a quotation with ID
		Quotation quotation = new Quotation();
		quotation = getQuotation(quotationID);

		ArrayList<Product> products = new ArrayList<>();
		QuotationDAO quotationdao = new QuotationDAO();

		products = quotationdao.getListProductsInAQuotation(quotationID);

		// Get the request
		HttpServletRequest req;
		req = (HttpServletRequest) request;
		
		HttpSession session;
		session = req.getSession();

		Report report = new Report();

		if (session.getAttribute("user") != null) {
			String user;
			user = (String) session.getAttribute("userType");

			if (user.equals("manager")) {
				report = new ReportManager(products, quotation, 0.0);
			} else if (user.equals("provider") && !quotationIsOn) {
				String providerName;
				providerName = (String) session.getAttribute("user");
				report = new ReportProvider(products, quotation, 0.0, providerName);
			}
			else if(user.equals("provider") && quotationIsOn){
				report = new ReportManager(products, quotation, 0.0);
			}
		}

		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		productsForProvider = report.showProducts();
		
		ArrayList<String> priceAsString = new ArrayList<>();
		for(int i = 0; i < productsForProvider.get(2).size(); ++i){
			
			ArrayList<Double> listPrice;
			listPrice = productsForProvider.get(2);
			
			Double priceProduct;
			priceProduct = (Double)listPrice.get(i);
			
			String priceDecimalFormatAsString;
			priceDecimalFormatAsString = Calculations.formatDecimal(priceProduct);
			
			priceAsString.add(priceDecimalFormatAsString);
			
		}
		
		request.setAttribute("listProducts", productsForProvider.get(0));
		request.setAttribute("listProviders", productsForProvider.get(1));
		request.setAttribute("listPrices", priceAsString);
		
		
		
		// Dispacher the result from the view of confirmation
		
		String urlToSend = null;
		
		
		if(quotationIsOn)
			urlToSend = "/DisputeQuotation.jsp";
		else
			urlToSend = "/ShowReport.jsp";
		
		System.out.println("PAssou pagian: " + urlToSend);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher(urlToSend);
		rd.forward(request, response);
	}

	private boolean verifyStateQuotation(HttpServletRequest request) {
		
		String quotationIsOn;
		quotationIsOn = request.getParameter("isOn");
		
		boolean quotationIsOnBool;
		quotationIsOnBool = Boolean.parseBoolean(quotationIsOn);
		
		return quotationIsOnBool;
	}

	private int getQuotationID(HttpServletRequest request) {

		String quotationId;
		quotationId = request.getParameter("quotationId");
		
		int integerQuotationID;
		integerQuotationID = Integer.parseInt(quotationId);

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
