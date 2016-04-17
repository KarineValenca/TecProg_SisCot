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

/**
 * Servlet implementation class DisputeQuotation
 */
@WebServlet("/DisputeQuotation")
public class DisputeQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisputeQuotation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
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
				
			
			
			
		}
		
		QuotationDAO quotationdao = new QuotationDAO();
		quotationdao.updateQuotationPrices(products, priceOfProducts, integerQuotationId, providerName);
		
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
