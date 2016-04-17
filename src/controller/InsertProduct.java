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
 * Servlet implementation class IncludeProduct
 */
@WebServlet("/IncludeProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**Creating new Product
     * @see HttpServlet#HttpServlet()
     */
    public InsertProduct() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
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
		}
		else {
			wasAdd = 2;
		}
		
		return wasAdd;
	}
	
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
