/*
 * Class name: Product.java
 * Purpose of class: This class is used to store all attributes from product.
 * Copyright: This software follows GPL license.
 */

package model;

public class Product {

	private String productName;
	private double productPrice;
	private Provider productProvider;

	public Product() {

	}

	public Product(String productName, double productPrice, Provider productProvider) {
		super();

		this.productName = productName;
		this.productPrice = productPrice;
		this.productProvider = productProvider;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Provider getProductProvider() {
		return productProvider;
	}
	public void setProductProvider(Provider productProvider) {
		this.productProvider = productProvider;
	}
}
