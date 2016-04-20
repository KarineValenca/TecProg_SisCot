/*
 * Class name: ConsultQuotation.java
 * Purpose of class: This class is used to consult quotes.
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


public abstract class  ConsultQuotation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConsultQuotation() {
		super();
	}

	protected abstract void service(HttpServletRequest request, HttpServletResponse response)
                                                               throws ServletException, IOException;
	protected abstract ArrayList<Quotation> buildQuotationList();
}
