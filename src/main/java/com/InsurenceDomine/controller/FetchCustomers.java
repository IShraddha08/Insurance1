package com.InsurenceDomine.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import insurance.customer.bean.InsuranceDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class FetchCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FetchCustomers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");		
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("Insurencedata");
		List<InsuranceDetails> li=null;
		if(obj!=null) {
		li=(ArrayList<InsuranceDetails>)obj;
		}
		PrintWriter out=response.getWriter();				
		out.print("<html><head><body><table border=\"1\" >");
		out.print("<tr><th width=\"200\">Vehicle Reg.No &nbsp;</th><th width=\"200\">Vehicle Make&nbsp;</th>"
				+ "<th width=\"200\">Vehicle Model&nbsp;&nbsp;</th><th width=\"200\">Vehicle CC&nbsp;</th>"
				+ "<th width=\"200\">Fuel Type&nbsp;&nbsp;&nbsp;&nbsp;</th><th width=\"200\">Chassis No&nbsp;</th>"
				+ "<th>Engine No&nbsp;</th><th>Manufacturing Year&nbsp;</th><th width=\"200\">Vehicle Reg.Date &nbsp;</th>"
				+ "<th>Insured Name&nbsp;</th><th>Policy No&nbsp;</th><th>Policy Start Date&nbsp;</th>"
				+ "<th>Policy End Date&nbsp;</th><th>Insured Declared Value&nbsp;</th><th>PA Cover for Passengers&nbsp;</th>"
				+ "<th>No.Of Passengers&nbsp;</th><th>Eligible NCB&nbsp;</th><th>Address&nbsp;</th><th>Pincode&nbsp;</th>"
				+ "<th>Mobile-No&nbsp;</th><th>Email&nbsp;</th></tr>");		 
		li.forEach(cmr->out.print("<tr><td>"+cmr.getVregno()+" </td><td>"+cmr.getVmake()+"</td><td>"+cmr.getVmodel()+" </td><td>"+cmr.getVcc()+"</td><td align=\"center\">"+cmr.getFueltype() +"</td><td>"+cmr.getChassisno()+"</td>"
					+ "<td>"+cmr.getEngineno()+"</td><td align=\"center\" >"+cmr.getMfno()+" </td><td align=\"center\">"+cmr.getVrdate()+"</td><td>"+cmr.getName()+" </td><td>"+cmr.getPolicyno()+" </td><td align=\"center\">"+cmr.getStartdate()+" </td>"
					+ "<td align=\"center\">"+cmr.getExpirydate()+"</td><td align=\"center\">"+cmr.getIdvalue() +"</td><td align=\"center\">"+cmr.getPacover()+"</td><td align=\"center\">"+cmr.getNpassenger()+"</td><td>"+cmr.getNcb()+
					"</td><td>"+cmr.getAddress()+"</td>"+ "<td align=\"center\">"+cmr.getPincode()+"</td><td align=\"center\">"+cmr.getMobileno() +"</td><td>"+cmr.getEmailid()+" </td><br><br><br>"));
		
		 out.print("</table>");
		out.print("<font \"><center><button ><a index.html><span ><h3>RETURN</h3></span></a></button></center></font>");
        out.print("</body></head></html>");
		
		}
		
	

}
