/**
 * File name: ConsultProduct.java
 * Purpose of File: This file contains the ConsultProduct class and its methods.
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

import model.Product;
import dao.ProductDAO;

/**
 * Class name: ConsultProduct
 * Purpose of class: This class is used to consult products.
 */
@WebServlet("/ConsultProduct")
public class ConsultProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConsultProduct() {
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductDAO productdao = new ProductDAO();
		String url  = request.getHeader("Referer");
		
		productList = productdao.listProducts();
		request.setAttribute("products", productList);
		
		System.out.println("url: " + url);

		RequestDispatcher rd;
		if(url.contains("Quotation")) {
			rd = request.getRequestDispatcher("/IncludeQuotationView.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/ConsultProductList.jsp");
		}
  		rd.forward(request,response);
	}
}
