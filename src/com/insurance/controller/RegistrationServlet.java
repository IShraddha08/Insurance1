package com.insurance.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurance.details.InsuranceDetails;
import com.insurance.jdbc.DBOperations;

public class RegistrationServlet extends HttpServlet {

	public RegistrationServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date dt=new Date();
		System.out.println("Getting data from insert operation");
		String vrgno1=request.getParameter("vrgno");
		String vmake1=request.getParameter("vmake");
		String vmodel1=request.getParameter("vmodel");
		String vcc1=request.getParameter("vcc");
		int vcc2=Integer.parseInt(vcc1);
	    String fueltype1=request.getParameter("fueltype") ;
		String chassisno1=request.getParameter("chassisno");
		String engineno1=request.getParameter("engineno");
		long engineno2=Long.parseLong(engineno1);
		String mfno1=request.getParameter("mfno");
		int mfno2=Integer.parseInt(mfno1);
		String vrdate1=request.getParameter("vrdate");
		String Iname1=request.getParameter("Iname");
        String policyno1=request.getParameter("policyno");
		String startdate1=request.getParameter("startdate");
		String expirydate1=request.getParameter("expirydate");
		String idvalue1=request.getParameter("idvalue");
		double idvalue2=Double.parseDouble(idvalue1);
		String pacover1=request.getParameter("pacover");
		double pacover2=Double.parseDouble(pacover1);
		String npassenger1=request.getParameter("npassenger");
		int npassenger2=Integer.parseInt(npassenger1);
		String ncb1=request.getParameter("ncb");
		int ncb2=Integer.parseInt(ncb1);
		String name1=request.getParameter("name");
		String address1=request.getParameter("address");
		String pincode1=request.getParameter("pincode");
		long pincode2=Long.parseLong(pincode1);
		String mobileno1=request.getParameter("mobileno");
		long mobileno2=Long.parseLong(mobileno1);
		String emailid1=request.getParameter("emailid");
		
		InsuranceDetails Id=new InsuranceDetails();
		Id.setVregno(vrgno1);
		Id.setVmake(vmake1);
		Id.setVmodel(vmodel1);
		Id.setVcc(vcc2);
		Id.setFueltype(fueltype1);
		Id.setChassisno(chassisno1);
		Id.setEngineno(engineno2);
		Id.setMfno(mfno2);
		Id.setVrdate(dt);
		Id.setIname(Iname1);
		Id.setPolicyno(policyno1);
		Id.setStartdate(dt);
		Id.setExpirydate(dt);
		Id.setIdvalue(idvalue2);
		Id.setPacover(pacover2);
		Id.setNpassenger(npassenger2);
		Id.setNcb(ncb2);
		Id.setName(name1);
		Id.setAddress(address1);
		Id.setPincode(pincode2);
		Id.setMobileno(mobileno2);
		Id.setEmailid(emailid1);
		
		DBOperations db=new DBOperations();
		int result=db.insertData(Id);
		
		HttpSession session=request.getSession();
		session.setAttribute("InsuranceObject", Id);
		
		RequestDispatcher RD=request.getRequestDispatcher("InsuranceData");
	    RequestDispatcher failure=request.getRequestDispatcher("Fail.html");
	    
	    if(result>0) {
	    	RD.forward(request, response);
	    }else {
	    	failure.forward(request, response);
	    }
		
	}
}
