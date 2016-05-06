/**
 * File name: ReportProvider.java
 * Purpose of file: This file is composed by ReportProvider class and methods.
 * Copyright: This software follows GPL license.
 */
package model;

import java.util.ArrayList;

import dao.ReportDAO;

import model.Report;

/**
 * Class name: ReportProvider
 * Purpose of class: This class is a extension of Report class. Responsible for
 * stablish what will show in a report provider.
 */
public class ReportProvider extends Report {

	private String providerName;
	
	/**
	 * Method name: ReportProvider
	 * Purpose of method: This method is a constructor method.
	 * @param products ArrayList of product type. 
	 * @param quotation Quotation object instance.
	 * @param totalPrice Represents total price of products. 
	 * @param providerName Represents the provider name.
	 */
	public ReportProvider(ArrayList<Product> products, Quotation quotation, double totalPrice, 
			String providerName) {
		
		super(products, quotation, totalPrice);
		this.providerName = providerName;
	}

	/**
	 * Method name: showProducts
	 * Purpose of method: This method stablish the lists that will show in a 
	 * report provider: products, providers and prices lists.
	 * @return productsForProvider This attribut is an ArrayList used to store 
	 * the products, providers and prices lists.
	 */
	public ArrayList<ArrayList> showProducts() {
		ReportDAO reportdao = new ReportDAO();
				
		int quotationIdForReport = getQuotation().getId();
		String providerNameForReport = getProviderName();
		
		ArrayList<String> listProducts = reportdao.listProductsProvider(quotationIdForReport, providerNameForReport);
		
		ArrayList<String> listProviders = reportdao.listProvidersProvider(quotationIdForReport, providerNameForReport);
		
		ArrayList<Double> listPrice = reportdao.listPriceProductsProvider(quotationIdForReport, providerNameForReport);

		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		
		productsForProvider.add(listProducts);
		productsForProvider.add(listProviders);
		productsForProvider.add(listPrice);

		return productsForProvider;

	}
	
	/**
	 * Method name: getProviderName
	 * Purpose of method: This method gets the providerName for use in report
	 * @return providerName Represents the provider name. 
	 */
	private String getProviderName() {
		return providerName;
	}

}

