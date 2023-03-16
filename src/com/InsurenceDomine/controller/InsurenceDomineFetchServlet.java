package com.InsurenceDomine.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.insurance.details.InsuranceDetails;
import com.insurance.jdbc.DbOperation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class InsurenceDomineFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbOperation db=new DbOperation();

    public InsurenceDomineFetchServlet() {
    	
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		InsuranceDetails cmr = new InsuranceDetails();
		DateFormat dt= new SimpleDateFormat("YYYY/MM/DD");

		System.out.println("Form submitted on Get insurance registration Page");	
		String vrn = request.getParameter("vregno");	cmr.setVregno(vrn)	;		
		String vm  = request.getParameter("vmake");     cmr.setVmake(vm);
		String vm1 = request.getParameter("vmodel ");	cmr.setVmodel(vm1);	
		String vc   =request.getParameter("vcc");
		int sd=Integer.parseInt(vc);					cmr.setVcc(sd);
		String Ch = request.getParameter("chassisno");  cmr.setChassisno(Ch);
		String en = request.getParameter("engineno");
		long ll=Long.parseLong(en);						cmr.setEngineno(ll);
		String fu = request.getParameter("fueltype");   cmr.setFueltype(fu);
		String my=request.getParameter("mfno"); 
		int in=Integer.parseInt(my);					cmr.setMfno(in);		
		try {
			String  vrd =request.getParameter("vrdate"); 
			Date fgg = dt.parse(vrd);       			cmr.setVrdate(fgg);
			String rgd=request.getParameter("psd");
			Date dt2=dt.parse(rgd);						cmr.setStartdate(dt2);
			String rgd1=request.getParameter("ped");
			Date dt3=dt.parse(rgd1);					cmr.setExpirydate(dt3);
			String dtt=(request.getParameter("vrdate"));	
			Date dt4=dt.parse(dtt);						cmr.setVrdate(dt4);	
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		String in1  = request.getParameter("Iname");    cmr.setIname(in1);
		String na=request.getParameter("name");			cmr.setName(na);
		String ad=request.getParameter("address");		cmr.setAddress(ad);
		String p=request.getParameter("pincode");		
		long pin=Long.parseLong(p);      				cmr.setPincode(pin);
		String mo = request.getParameter("mobileno");	
		long mob=Long.parseLong(mo);				   cmr.setMobileno(mob);
		
		String ei =request.getParameter("emailid");    cmr.setEmailid(ei);
		String pn =request.getParameter("policyno");   cmr.setPolicyno(pn);
		
		String idv =request.getParameter("idvalue");   
		double idv1=Double.parseDouble(idv);  		   cmr.setIdvalue(idv1);
		String pcp =request.getParameter("pacover");   
		double idv2=Double.parseDouble(pcp);  		   cmr.setPacover(idv2);
		String np=request.getParameter("npassenger");  
		int np1 =Integer.parseInt(np); 				   cmr.setNpassenger(np1);
		String en1 =request.getParameter("number");    
		
		
		
		
		DbOperation db = new DbOperation();
		int result=db.insertInsuranceDetails(cmr);		
		HttpSession session=request.getSession();
		session.setAttribute("InsurenceObj", result);
		
		RequestDispatcher RD=request.getRequestDispatcher("/InsurenceData1");
		//RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
		
		if(cmr!=null) {
			RD.forward(request, response);		
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
