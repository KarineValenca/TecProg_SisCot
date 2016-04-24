/*
 * Class name: UpdateProduct.java
 * Purpose of class: This class is used to update a product at database.
 * Copyright: This software follows GPL license.
 */

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import dao.ProductDAO;

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public UpdateProduct() {
		super();		
	}
	
	protected void service(HttpServletRequest request, 
						   HttpServletResponse response) 
						   throws ServletException, IOException {
		String messageUpdateConfirmation;
		mmessageUpdateConfirmation = "Iniciada";
		boolean wasUpdated;
		wasUpdated = sendToProductDAO(request);
		
		if(wasUpdated) {
			messageUpdateConfirmation = "Produto atualizado com sucesso!";
		}
		else {
			messageUpdateConfirmation = "Produto não foi atualizado!";
		}
		
		request.setAttribute("mensage", messageUpdateConfirmation);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}
	
	public boolean sendToProductDAO(HttpServletRequest request) {
		boolean wasUpdated;
		wasUpdated = false;
		String actualProductName;
		actualProductName = (String) request.getParameter("actualName");
		assert(actualProductName != null) : "the actual product name is "
											 + "recieving null from view";	
		Product product = new Product();
		product.setProductName(request.getParameter("name"));
		ProductDAO productDAO = new ProductDAO();
		wasUpdated = productDAO.updateProduct(actualProductName, product);
		return wasUpdated;
	}
}
