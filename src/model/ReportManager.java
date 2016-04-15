package model;

import java.util.ArrayList;

import dao.ReportDAO;

public class ReportManager extends Report{

	public ReportManager(ArrayList<Product> products, Quotation quotation, double totalPrice) {
		super(products, quotation, totalPrice);
	}

	@Override
	public ArrayList<ArrayList> showProducts() {
		ReportDAO reportdao = new ReportDAO();
		
		ArrayList<String> listProducts; 
		listProducts = reportdao.listProductsManager(getQuotation().getId());
		
		ArrayList<String> listProviders;
		listProviders = reportdao.listProvidersManager(getQuotation().getId());
		
		ArrayList<Double> listPrice; 
		listPrice = reportdao.listPriceProducts(getQuotation().getId());
		
		ArrayList<ArrayList> productsForProvider = new ArrayList<>();
		
		productsForProvider.add(listProducts);
		productsForProvider.add(listProviders);
		productsForProvider.add(listPrice);
		
		return productsForProvider;
	}

}
