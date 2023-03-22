package com.InsurenceDomine.controller;

import java.io.IOException;

import com.dbOperation.conm.DbOperation;

import insurance.customer.bean.InsuranceDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name=request.getParameter("name");
		DbOperation db=new DbOperation();
		InsuranceDetails result=db.Searchdata(name);
		result.setName(name);
		
		HttpSession session=request.getSession();
		session.setAttribute("SearchObj", result);
		
		RequestDispatcher req=request.getRequestDispatcher("/ClaimDataView");
		RequestDispatcher fail=request.getRequestDispatcher("/Fail.html");

		if(result!=null) {
			req.forward(request, response);
		}
		
	}

}
