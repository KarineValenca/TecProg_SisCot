/*
 * Class name: ReportManager.java
 * Purpose of class: This class is a extension of Report class. Responsible for
 * stablish what will show in a report manager.
 * Copyright: This software follows GPL license.
 */
package model;

import java.util.ArrayList;

import dao.ReportDAO;

public class ReportManager extends Report{

	// this method is a constructor method
	public ReportManager(ArrayList<Product> products, Quotation quotation, double totalPrice) {
		super(products, quotation, totalPrice);
	}

	/*this method establish the lists that will show in a report manager: 
	products, providers and prices lists.*/
	public ArrayList<ArrayList> showProducts() {
		ReportDAO reportdao = new ReportDAO();
		
		int quotationIdForReport = getQuotation().getId();
		
		ArrayList<String> listProducts = reportdao.listProductsManager(quotationIdForReport);
		
		ArrayList<String> listProviders = reportdao.listProvidersManager(quotationIdForReport);
		
		ArrayList<Double> listPrice = reportdao.listPriceProducts(quotationIdForReport);
		
		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		
		productsForProvider.add(listProducts);
		productsForProvider.add(listProviders);
		productsForProvider.add(listPrice);
		
		return productsForProvider;
	}

}
