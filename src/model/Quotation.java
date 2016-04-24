/*
 * Class name: Quotation.java
 * Purpose of class: This class is used to store all attributes from quotation.
 * Copyright: This software follows GPL license.
 */

package model;

import java.sql.Date;
import java.util.ArrayList;

public class Quotation {
	private ArrayList<Product> products;
	private Date quotationDate;
	private String managerName;
	private boolean quotationIsOn;
	private int id;
	
	public Quotation(ArrayList<Product> products, Date quotationDate, 
			         String managerName, int id) {
		super();
		this.products = products;
		this.quotationDate = quotationDate;
		this.managerName = managerName;
		this.id = id;
	}

	public Quotation () {
		super();
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public Date getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getQuotationIsOn() {
		return quotationIsOn;
	}

	public void setQuotationIsOn(boolean quotationIsOn) {
		this.quotationIsOn = quotationIsOn;
	}
}
