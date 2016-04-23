/*
 *Class name: InsertProduct.java
 *Purpose of class: This class is responsible to include a product.
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

public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*this method is a constructor method of the class. Responsible to create 
	a new product.*/
	public InsertProduct() {
        super();
    }

	/*This method is responsible for, using the RequestDispatcher objetc, acess
 	the ProductsResponse views pages, according to the requested action.*/
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
	
	/*this method is responsible to add the new product into the database and 
	verify if the product was add successfully.*/
	public int insertProduct(String nameProduct){
		assert (nameProduct != null) : "The request from client is null";
				
		boolean daoWasAdd = false;
		
		/* 
		 * Flag to identify the result of the operation.
		 * 0 -> Could not save on Database.
		 * 1 -> Successful saved on Database.
		 * 2 -> Empty product name.
		 */
		int wasAdd = 0; 
		
		nameProduct = nameProduct.trim();
		
		if(!nameProduct.equals("")) {
			
			Product product = new Product(); 
			product.setProductName(nameProduct);
			product.setProductPrice(0.0);
			product.setProductProvider(null);
			
			//Flag to verify if the Product was add in the DataBase
			
			
			//Acess the DAO class and adding the new product
			ProductDAO productdao = new ProductDAO();
			daoWasAdd = productdao.insertProduct(product);
			
			if(daoWasAdd) {
				wasAdd = 1;
			}
			else {
				//nothing to do
			}
		}
		else {
			wasAdd = 2;
		}
		
		return wasAdd;
	}
	
	// this method is responsible to show a message for the product addition.
	private String messageHandling(int wasAdd) {
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
