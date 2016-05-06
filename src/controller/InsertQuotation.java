/**
 * File name: InsertQuotation.java
 * Purpose of class: This class is used to enter new quotes, and their products.
 * Copyright: This software follows GPL license.
 **/

package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Quotation;
import dao.ProductDAO;
import dao.QuotationDAO;

/**
 * Class name: InsertQuotation
 * Purpose of class: Servlet implementation class IncludeProduct
 **/
@WebServlet("/IncludeQuotation")
public class InsertQuotation extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
            * Method name: insertQuotation
            * Purpose of method: Creating new Quotation
            * @see HttpServlet#HttpServlet()
            **/
	public InsertQuotation() {
		super();
	}

	/**
            * Method name: service
            * Purpose of method: This method is used to get some values from view and
            * pass the result of the method insertProvider to view.
            * @param request: used to represent the HTTP request that a browser sends
            * to the application.
            * @param response: used to represent the HTTP response that the application
            * sends to a browser.
            **/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {

		String messageAddConfirmation = "Iniciada";
		HttpSession session = request.getSession();

		//Get name and description of the IncludeProducView
		String managerName = (String) session.getAttribute("user");
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		Quotation quotation = createNewCotation(managerName, sqlDate);

		quotation.setQuotationIsOn(true);
		int id = insertQuotation(quotation);
		quotation.setId(id);

		selectProducts(request, quotation);

		if(id != 0) {
			messageAddConfirmation = "Cotação criada com sucesso!";
		}
		else {
			messageAddConfirmation = "Erro! Houve um problema na criação da Cotação!";
		}
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", messageAddConfirmation);

		//Dispacher the result from the view of confirmation
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/QuotationResponse.jsp");
		rd.forward(request,response);
	}

          /**
     	* Method name: insertQuotation
    	* Purpose of method: This method is add the new quotation into the database
    	* and verify if the quotation was add successfully.
    	* @param quotation: this object quotation to be inserted in the database.
     	* @return wasAdd: this boolean value is used to verify if the quotation
    	* was inserted.
     	**/
	public int insertQuotation(Quotation quotation) {
		assert(quotation != null) : "unexpected error: the quotation is null";
		int id;

		QuotationDAO quotationdao = new QuotationDAO();
		id = quotationdao.includeQuotation(quotation);

		return id;
	}

	/**
     	* Method name: selectProducts
    	* Purpose of method: Select the products of quotation
	* @param request: this attribute is used to represent the HTTP request
    	* @param quotation: this object quotation to be inserted in the database.
     	**/
	private void selectProducts(HttpServletRequest request, Quotation quotation) {
		assert(request != null) : "unexpected error: the request is null";
		assert(quotation != null) : "unexpected error: the quotation is null";
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductDAO productdao = new ProductDAO();

		productList = productdao.listProducts();

		for (Product product : productList) {
			String productName;
			productName = product.getProductName();

			String nameProduct;
			nameProduct = request.getParameter(productName);

			if(nameProduct != null){
				QuotationDAO quotationDAO = new QuotationDAO();
				quotationDAO.includeQuotationProduc(quotation, product);
			}
			else {
				//nothing to do
			}
		}
	}

	/**
     	* Method name: createNewCotation
    	* Purpose of method: create a new quote products
	* @param managerName: this attribute is name of the creator of the quotation
    	* @param quotationDate: date of quotation
    	* @return quotation: the object quotation created
     	**/
	private Quotation createNewCotation(String managerName, Date quotationDate){
		assert(managerName != null) : "unexpected error: the managerName is null";
		assert(quotationDate != null) : "unexpected error: the quotationDate is null";
		Quotation quotation = new Quotation();
		quotation.setManagerName(managerName);
		quotation.setQuotationDate(quotationDate);
		quotation.setProducts(null);

		return quotation;
	}
}

