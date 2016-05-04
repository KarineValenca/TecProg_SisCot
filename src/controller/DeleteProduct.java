/** 
* File name: DeleteProduct.java
* Purpose of file: This file contains the DeleteProduct class and its methods.   
* Copyright: Copyright: This software follows GPL license.
**/ 

package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDAO;

/**
 * Class name: DeleteProdut.java
 * Purpose of class: This class is used to exclude a provider from database.
 **/
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProduct() {
        super();
    }
    
    /** 
    * Method name: service
    * Purpose of method: this method is used to get some values from view and 
    * pass the result of the method deleteProduct to view.  
    * @param request: used to represent the HTTP request that a browser sends
    * to the application.
    * @param response: used to represent the HTTP response that the application
    * sends to a browser.
    * @return there is no return.
    **/
	protected void service(HttpServletRequest request, 
						   HttpServletResponse response) throws
		ServletException, IOException {
		String productName;
		productName =  request.getParameter("productName");
		assert(productName != null) : "The product name is recieving null from "
									   + "view";
		String messageDeletedConfirmation;
		messageDeletedConfirmation = "Iniciada";
		boolean wasDeleted;
		wasDeleted = deleteProduct(productName);
		
		if(wasDeleted) {
			messageDeletedConfirmation = "Produto Excluído com Sucesso!";
		}
		else {
			messageDeletedConfirmation = "Erro! O produto não pode ser "
										  + "excluído.";
		}

		request.setAttribute("mensage", messageDeletedConfirmation);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}
   
	/** 
    * Method name: deleteProduct
    * Purpose of method: this method is used to delete a product from database.  
    * @param productName: this string gets the product name from the view.
    * @return wasDeleted: This boolean value is used to verify if the product 
    * was deleted.
    **/	
	public boolean deleteProduct(String productName) {
		assert(productName != null) : "The product name is recieving null";
		boolean wasDeleted = false;
		ProductDAO productdao; 
		productdao = new ProductDAO();
		System.out.println("Nome do Produto:" + productName);
		wasDeleted = productdao.deleteProduct(productName);	
		return wasDeleted;
	}
}
