package model;

import java.util.ArrayList;

import dao.ReportDAO;

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

		ArrayList<String> listProducts = reportdao.listProductsProvider(getQuotation().getId(), providerName);
		ArrayList<String> listProviders = reportdao.listProvidersProvider(getQuotation().getId(), providerName);
		ArrayList<Double> listPrice = reportdao.listPriceProductsProvider(getQuotation().getId(), providerName);

		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		productsForProvider.add(listProducts);
		productsForProvider.add(listProviders);
		productsForProvider.add(listPrice);

		return productsForProvider;

	}

}

