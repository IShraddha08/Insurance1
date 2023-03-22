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

public class InsurenceDomineFetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsurenceDomineFetchServlet() {
    	
        super();
    }  	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		InsuranceDetails cmr = new InsuranceDetails();

		System.out.println("Form submitted on Get insurance registration Page");
		
		String vrn = request.getParameter("vregno");	cmr.setVregno(vrn)	;		
		String vm  = request.getParameter("vmake");     cmr.setVmake(vm);
		String vm1 = request.getParameter("VMODELLL ");	
		cmr.setVmodel(vm1);	
		String vc   =request.getParameter("vcc");
		int sd=Integer.parseInt(vc);					cmr.setVcc(sd);
		String Ch = request.getParameter("chassisno");  cmr.setChassisno(Ch);
		String en = request.getParameter("engineno");
														cmr.setEngineno(en);
		String fu = request.getParameter("fueltype");   cmr.setFueltype(fu);
		String my=request.getParameter("mfno"); 
		int in=Integer.parseInt(my);					cmr.setMfno(in);		
		String  vrd =request.getParameter("vrdate"); 
														cmr.setVrdate(vrd);
		String rgd=request.getParameter("polstartdate");
														cmr.setStartdate(rgd);
		String rgd1=request.getParameter("polendtdate");
														cmr.setExpirydate(rgd1);
		
		String in1  = request.getParameter("Iname");    cmr.setIname(in1);
		String na=request.getParameter("name");			cmr.setName(na);
		String ad=request.getParameter("address");		cmr.setAddress(ad);
		String p=request.getParameter("pincode");		
		     											cmr.setPincode(p);
		String mo = request.getParameter("ncb");
		 int sd1=Integer.parseInt(mo);                  cmr.setNcb(sd1);																
		String ei =request.getParameter("emailid");     cmr.setEmailid(ei);
		String pn =request.getParameter("policyno");    cmr.setPolicyno(pn);		
		String idv =request.getParameter("idvalue");   
		 		   										cmr.setIdvalue(idv);
		String pcp =request.getParameter("pacover");   
		double idv2=Double.parseDouble(pcp);  		    cmr.setPacover(idv2);
		String np=request.getParameter("npassenger");  
														cmr.setNpassenger(np);
		String en1 =request.getParameter("mobileno");     cmr.setMobileno(en1);
		
		String pre=request. getParameter("premium");
		cmr.setPremium(pre);				
		DbOperation db = new DbOperation();
		int result=db.insertInsuranceDetails(cmr);		
		HttpSession session=request.getSession();
		session.setAttribute("InsurenceObj", cmr);
		
		RequestDispatcher RD=request.getRequestDispatcher("/InsurenceData1");
		RequestDispatcher failure = request.getRequestDispatcher("Fail.html");
		
		if(result>0) {
			RD.forward(request, response);		
		}
		
		else {
			failure.forward(request, response);
		}
		
		
		
		
		
	}
	
	
	
	

}
