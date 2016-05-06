/** 
 * File name: UpdateProduct.java
 * Purpose of file: This file contains the UpdateProduct class and its methods.   
 * Copyright:This software follows GPL license.
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

/**
 *Class name: InsertProvider.java
 *Purpose of class: This class is responsible for the change of the product at database.
 */
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /** 
     * Method name: InsertProvider
     * Purpose of method: This method is a constructor method of the class. 
     * Responsible to update a product.  
     */	
	public UpdateProduct() {
		super();		
	}

    /** 
     * Method name: service
     * Purpose of method: This method is used to get some values from view and 
     * pass the result of the method updateProvider to view.  
     * @param request: used to represent the HTTP request that a browser sends
     * to the application.
     * @param response: used to represent the HTTP response that the application
     * sends to a browser.
     */
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
		
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", messageUpdateConfirmation);
		
		//Dispacher the result from the view of confirmation
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}

    /** 
     * Method name: sendToProductDAO
     * Purpose of method: this method is used to update a provider at database.  
     * @param request: used to represent the HTTP request that a browser sends
     * to the application.
     * @return wasUpdated: This boolean value is used to verify if the product 
     * was updated.
     */
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
