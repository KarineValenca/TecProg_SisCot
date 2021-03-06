/** 
 * File name: Quotation.java
 * Purpose of file: This file contains the Quotation class and its methods.   
 * Copyright: This software follows GPL license.
 */

package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Class name: Quotation
 * Purpose of class: TThis class is responsible for defines the attributes of a 
 * quotation.
 */
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
