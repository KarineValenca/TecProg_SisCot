/*
 * Class name: ReportProvider.java
 * Purpose of class: This class is a extension of Report class. Responsible for
 * stablish what will show in a report provider.
 * Copyright: This software follows GPL license.
 */
package model;

import java.util.ArrayList;

import dao.ReportDAO;

import model.Report;

public class ReportProvider extends Report {

	private String providerName;

	// this method is a constructor method
	public ReportProvider(ArrayList<Product> products, Quotation quotation, double totalPrice, 
			String providerName) {
		
		super(products, quotation, totalPrice);
		this.providerName = providerName;
	}

	/* this method stablish the lists that will show in a report provider:
	products, providers and prices lists.*/
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
	
	// this method gets the providerName for use in report
	private String getProviderName() {
		return providerName;
	}

}

