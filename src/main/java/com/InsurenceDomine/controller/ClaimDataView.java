package com.InsurenceDomine.controller;
import java.io.IOException;
import java.io.PrintWriter;

import insurance.customer.bean.ClaimBean;
import insurance.customer.bean.InsuranceDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ClaimDataView extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    public ClaimDataView() {
    	super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		 HttpSession session=request.getSession();
	     // Object claim=session.getAttribute("ClaimObj");
		 Object search=session.getAttribute("SearchObj");
		 InsuranceDetails cmr=null;
		 PrintWriter out=response.getWriter();
	    // ClaimBean del =null;
	     if(search!=null) {
		     cmr= (InsuranceDetails)search; 
		     out.print("<html><head><body><font><center><h3>POLICY -DETAILS</h3></center></font><table border=\"1\" >");
				out.print("<tr ><th >Vehicle Reg.No</th><th >Vehicle Make</th>"
						+ "<th >Vehicle Model</th><th >Vehicle Reg.Date</th>"
						+ "<th>Insured Name&nbsp;</th><th>Policy No&nbsp;</th><th>Policy Start Date&nbsp;</th>"
						+ "<th>Policy End Date&nbsp;</th><th>Insured Declared Value&nbsp;</th></tr>");
				
				out.print("<tr><td>"+cmr.getVregno()+" </td><td>"+cmr.getVmake()+"</td><td>"+cmr.getVmodel()+" </td>"
						+ "<td align=\"center\">"+cmr.getVrdate()+"</td><td>"+cmr.getName()+" </td><td>"+cmr.getPolicyno()+" </td><td align=\"center\">"+cmr.getStartdate()+" </td>"
						+ "<td align=\"center\">"+cmr.getExpirydate()+"</td><td align=\"center\">"+cmr.getIdvalue()+"</td></tr><br><r><br><br>");
						
		    		
				out.print("</table>");	
				out.print("<tr><td><font \"><center><button ><a index.html><span ><h3><a href='InsuranceClaim.jsp'>ProceedForClaiming</a></h3></span></a></button></center></font></td></tr>");
		        out.print("</body></head></html>");
				 

	     }
	     
	    /* if(claim!=null) {	    	 
	    	 del=(ClaimBean)claim;
	 		out.print("<html><head><body><table border=\"1\" >");
	 		out.print("<tr><th>ReasonClaim&nbsp;</th><th>TypeOfDamage&nbsp;</th>"
	 				+ "<th>IssueDate&nbsp;</th><th>VehicleParts&nbsp;</th><th>TotalCost&nbsp;</th></tr>");

	    	 out.print("<td align=\"center\">"+del.getReasion()+"</td><td align=\"center\">"+del.getTypeOfDamage()+"</td>"
	    	 		+ "<td align=\"center\">"+del.getParts()+"</td><td align=\"center\">"+del.getIssue()+"</td><td align=\"center\">"+del.getSum());
	
	    	 out.print("</table>");	
	 		out.print("<tr><td><font \"><center><button ><a ><span ><h3><a href=InsuranceClaim.jsp>OvrallOut</a></h3></span></a></button></center></font></td></tr>");
	         out.print("</body></head></html>");*/
	     
	     }
}
