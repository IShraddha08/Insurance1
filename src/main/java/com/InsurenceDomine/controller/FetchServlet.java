package com.InsurenceDomine.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.dbOperation.conm.DbOperation;

import insurance.customer.bean.InsuranceDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbOperation db=new DbOperation();

 
    public FetchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<InsuranceDetails> li= new ArrayList<InsuranceDetails>();		
		List<InsuranceDetails> data=db.FetchDataWithPreparedStatement();
		
		HttpSession session=request.getSession();
		session.setAttribute("Insurencedata", data);
	RequestDispatcher rdSuccess=request.getRequestDispatcher("FetchCustomers"); 
	RequestDispatcher rdFail=request.getRequestDispatcher("Fail.html"); 

		if(data!=null) {
			rdSuccess.forward(request, response);
		}
		else {
			rdFail.forward(request, response);
		}
	}

	
	
	}