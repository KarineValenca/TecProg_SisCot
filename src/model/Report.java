/*
 * File name: Publication.java
 * Purpose of class: This class is used to store all attributes from report.
 * Copyright: This software follows GPL license.
 */

package model;

import java.util.ArrayList;

/*
 * Class name: Publication
 * Purpose of class: This class implements methods of a model Report
 */
public class Report {
	private ArrayList<Product> products;
	private Quotation quotation;
	private double totalPrice;

	public Report() {

	}

	public Report(ArrayList<Product> products, Quotation quotation, double totalPrice) {
		super();
		this.products = products;
		this.quotation = quotation;
		this.totalPrice = totalPrice;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public Quotation getQuotation() {
		return quotation;
	}
	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ArrayList<ArrayList> showProducts(){
		return null;
	}
}
