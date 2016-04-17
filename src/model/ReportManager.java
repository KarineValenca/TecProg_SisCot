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
