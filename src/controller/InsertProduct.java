/**
 *File name: InsertProduct.java
 *Purpose of file: This file is composed by InserProduct class and methods.
 *Copyright: This software follows GPL license. 
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
import model.Product;

/**
 *Class name: InsertProduct.java
 *Purpose of class: This class is responsible to include a product.
 */
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Method name: InsertProduct 
     * Purpose of method: This method is a constructor method of the class.
     * Responsible to create a new product.
     */
	public InsertProduct() {
        super();
    }

	/**
	 * Method name: service
	 * Purpose of method: This method is responsible for, using the 
	 * RequestDispatcher objetc, acess the ProductsResponse views pages, 
	 * according to the requested action.
	 * @param request Request that a browser sends to the application.
	 * @param response Response that the application sends to a browser.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException {
		assert (request != null) : "The request from client is null";
		assert (response != null) : "The response to client is null";
		
		String messageAddConfirmation = "Iniciada";
		//Get name and description of the IncludeProducView
		String nameProduct = request.getParameter("name");
		int wasAdd = insertProduct(nameProduct);
		
		messageAddConfirmation = messageHandling(wasAdd);
		
		//Set the mensage for send to Product Response
		request.setAttribute("mensage", messageAddConfirmation);
		
		//Dispacher the result from the view of confirmation		
		RequestDispatcher rd = request.getRequestDispatcher("/ProductResponse.jsp");
        rd.forward(request,response);
	}
	
	/**
	 * Method name: insertProduct
	 * Purpose of method: This method is responsible to add the new product 
	 * into the database and verify if the product was add successfully.
	 * @param nameProduct Represents the name of product.
	 * @return wasAdd Used to represent the inser product status.
	 */
	public int insertProduct(String nameProduct){
		assert (nameProduct != null) : "The request from client is null";
			
		nameProduct = nameProduct.trim();
		
		/* 
		 * Flag to identify the result of the operation.
		 * 0 -> Could not save on Database.
		 * 1 -> Successful saved on Database.
		 * 2 -> Empty product name.
		 */
		int wasAdd = 0;
		
		if(!nameProduct.equals("")) {
			
			Product product = new Product(); 
			product.setProductName(nameProduct);
			product.setProductPrice(0.0);
			product.setProductProvider(null);
			
			//Flag to verify if the Product was add in the DataBase
			
			//Acess the DAO class and adding the new product
			boolean daoWasAdd = false;
			try{
				ProductDAO productdao = new ProductDAO();
				daoWasAdd = productdao.insertProduct(product);	
			} catch(RuntimeException productInsertError){
				daoWasAdd = false;
			}
			
			if(daoWasAdd) {
				wasAdd = 1;
			}
			else {
				wasAdd = 0;
			}
		}
		else {
			wasAdd = 2;
		}
		
		return wasAdd;
	}
	
	/**
	 * Method name: messageHandling
	 * Purpose of method: This method is responsible to show a message for the 
	 * product addition.
	 * @param wasAdd 
	 * @return Used to represent the inser product status.
	 */
	public String messageHandling(int wasAdd) {
		String messageAddConfirmation = "Iniciada";
		switch (wasAdd) {
		case 0:
			messageAddConfirmation = "Produto Não Foi Adicionado!";
			break;
			
		case 1:
			messageAddConfirmation = "Produto adicionado com sucesso!";
			break;
			
		case 2:
			messageAddConfirmation = "Nome do Produto em branco! Por favor, preencha com um nome";
			break;
		
		default:
			messageAddConfirmation = "Valor invalido no método messageHandling!";
			break;
		}
		
		return messageAddConfirmation;
	}

}
