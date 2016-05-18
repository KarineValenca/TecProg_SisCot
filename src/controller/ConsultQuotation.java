/**
 * File name: ConsultQuotation.java
 * Purpose of File: This file contains the ConsultQuotation class and its methods.
 * Copyright: This software follows GPL license.
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Quotation;

/**
 * Class name: ConsultQuotation
 * Purpose of Class: This class is used to consult quotes.
 */
public abstract class  ConsultQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConsultQuotation() {
		super();
	}

   /**
    * Method name: service
    * Purpose of method: By this method a consult at database is done and the
    * providers list is obtained.
    * @param request: this attribute is used to represent the HTTP request
    * that a browser sends to the application.
    * @param response: this attribute is used to represent the HTTP response
    * that the application sends to a browser.
    */
	protected abstract void service(HttpServletRequest request, HttpServletResponse response)
                                    throws ServletException, IOException;

   /**
    * Method name: buildQuotationList
    * Purpose of method: this method is used to consult the list of quotations in the database
    * @return: list quotation
    */
	protected abstract ArrayList<Quotation> buildQuotationList();
}
