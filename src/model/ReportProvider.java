package model;

import java.util.ArrayList;

import dao.ReportDAO;

import model.Report;

public class ReportProvider extends Report {

	private String providerName;

	public ReportProvider(ArrayList<Product> products, Quotation quotation, double totalPrice, 
			String providerName) {
		
		super(products, quotation, totalPrice);
		this.providerName = providerName;
	}

	@Override
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
	
	private String getProviderName() {
		return providerName;
	}

}

