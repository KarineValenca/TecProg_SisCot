/*
 * Class name: DeleteProdut.java
 * Purpose of class: This class is used to exclude a provider from database.
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

import dao.ProductDAO;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProduct() {
        super();
    }

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
