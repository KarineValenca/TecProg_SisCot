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
 * Servlet implementation class IncludeProduct
 */
@WebServlet("/IncludeQuotation")
public class InsertQuotation extends HttpServlet{
	private static final long serialVersionUID = 1L;


   /**Creating new Quotation
    * @see HttpServlet#HttpServlet()
    */
	public InsertQuotation() {
		super();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
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

	public int insertQuotation(Quotation quotation) {
		assert(quotation != null) : "unexpected error: the quotation is null";
		int id;

		QuotationDAO quotationdao = new QuotationDAO();
		id = quotationdao.includeQuotation(quotation);

		return id;
	}

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

