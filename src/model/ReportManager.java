/**
 * File name: ReportManager.java
 * Purpose of file: This file is composed by ReportManager class and methods.
 * Copyright: This software follows GPL license.
 */
package model;

import java.util.ArrayList;

import dao.ReportDAO;

/**
 * Class name: ReportManager
 * Purpose of class: This class is a extension of Report class. Responsible for
 * stablish what will show in a report manager.
 */
public class ReportManager extends Report{
	
	/**
	 * Method name: ReportManager
	 * Purpose of method: This method is a constructor method.
	 * @param products ArrayList of product type.
	 * @param quotation Quotation object instance.
	 * @param totalPrice Represents total price of products.
	 */
	public ReportManager(ArrayList<Product> products, Quotation quotation, double totalPrice) {
		super(products, quotation, totalPrice);
	}
	
	/**
	 * Method name: showProducts
	 * Purpose of method: This method establish the lists that will show in a 
	 * report manager: products, providers and prices lists.
	 * @return productsForProvider ArrayList used to store the products, 
	 * providers and prices lists.
	 */
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
