package com.InsurenceDomine.controller;

import java.io.IOException;
import java.io.PrintWriter;

import insurance.customer.bean.ClaimBean;
import insurance.customer.bean.InsuranceDetails;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ClaimOrallView extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClaimOrallView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 HttpSession session=request.getSession();
	      Object claim=session.getAttribute("ClaimObj");
		 Object search=session.getAttribute("SearchObj");		 
		 InsuranceDetails cmr=null;
		 PrintWriter out=response.getWriter();
	     ClaimBean del =null;	     
	    
		     cmr= (InsuranceDetails)search; 
	    	 del=(ClaimBean)claim;

		     out.print("<html><head><body>   REGISTRATION&nbsp; AND&nbsp; CLAIM&nbsp; DETAILS    <table border=\"1\" >");
				out.print("<tr ><th >Vehicle Reg.No</th><th >Vehicle Make</th>"
						+ "<th >Vehicle Model</th><th >Vehicle Reg.Date</th>"
						+ "<th>Insured Name&nbsp;</th><th>Policy No&nbsp;</th><th>Policy Start Date&nbsp;</th>"
						+ "<th>Policy End Date&nbsp;</th><th>Insured Declared Value&nbsp;</th><<th>ReasonClaim&nbsp;</th><th>TypeOfDamage&nbsp;</th>"
						+ "<th>IssueDate&nbsp;</th><th>VehicleParts&nbsp;</th><th>TotalCost&nbsp;</th></tr>");					
				out.print("<tr><td>"+cmr.getVregno()+" </td><td>"+cmr.getVmake()+"</td><td>"+cmr.getVmodel()+" </td>"
						+ "<td align=\"center\">"+cmr.getVrdate()+"</td><td>"+cmr.getName()+" </td><td>"+cmr.getPolicyno()+" </td><td align=\"center\">"+cmr.getStartdate()+" </td>"
						+ "<td align=\"center\">"+cmr.getExpirydate()+"</td><td align=\"center\">"+cmr.getIdvalue()+"</td>");		
				out.print("<td align=\"center\">"+del.getReasion()+"</td><td align=\"center\">"+del.getTypeOfDamage()+"</td>"
		    	 		+ "<td align=\"center\">"+del.getIssue()+"</td><td align=\"center\">"+del.getParts()+"</td><td align=\"center\">"+del.getSum()+"</td></tr>");	
				
				out.print("</table>");	
		        out.print("</body></head></html>");
		     
	     String date="";
		 if(search!=null) {
			 cmr=(InsuranceDetails)search;
			 date=cmr.getVrdate();
			 
		 }
		String sub= date.substring(0 ,4);
		int Regisdate=Integer.parseInt(sub);
	    String Cdate1=del.getIssue();
		String cda=Cdate1.substring(0, 4);
		int IssueDate=Integer.parseInt(cda);
		
		if((IssueDate-Regisdate)<=3) {
			out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
					+ "<table >");
	 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;100% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASEDUPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
	 		       out.print("<td>ONLY YOU HAVE TO PAY -"+del.getSum()+"&nbsp;\\- FOR YOUR DAMAGE</td>");
					out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

	 		      out.print("</table>");	
	 	         out.print("</body></head></html>");
		}
		else if((IssueDate-Regisdate)==4) {
			out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
					+ "<table >");
	 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;86% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASEDUPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
	 		       out.print("<td>ONLY YOU HAVE TO PAY -"+del.getSum()+"&nbsp;\\- FOR YOUR DAMAGE</td>");
					out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

	 		      out.print("</table>");	
	 	         out.print("</body></head></html>");
		}
		else if((IssueDate-Regisdate)==5) {
			out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
					+ "<table >");
	 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;75% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASEDUPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
	 		       out.print("<td>ONLY YOU HAVE TO PAY -"+del.getSum()+"&nbsp;\\- FOR YOUR DAMAGE</td>");
					out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

	 		      out.print("</table>");	
	 	         out.print("</body></head></html>");
		}
		else if((IssueDate-Regisdate)==6) {
			out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
					+ "<table >");
	 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;60% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASEDUPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
	 		       out.print("<td>ONLY YOU HAVE TO PAY -"+del.getSum()+"&nbsp;\\- FOR YOUR DAMAGE</td>");
					out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

	 		      out.print("</table>");	
	 	         out.print("</body></head></html>");
		}
		else if((IssueDate-Regisdate)==7) {
			out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
					+ "<table >");
	 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;30% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES &nbsp;BASEDUPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
	 		       out.print("<td>ONLY YOU HAVE TO PAY -"+del.getSum()+"&nbsp;\\- FOR YOUR DAMAGE</td>");
					out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

	 		      out.print("</table>");	
	 	         out.print("</body></head></html>");
		}
		else {
			out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
					+ "<table >");
	 		       out.print("<tr align='center'><th>YOU &nbsp;CAN'T GET ANY &nbsp;CLAIM &nbsp; &nbsp;ACCORDING&nbsp; TO&nbsp; OUR&nbsp; POLICY &nbsp;RULES</th></tr>");
					out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

	 		      out.print("</table>");	
	 	         out.print("</body></head></html>");
		}
			

		
		}
			 
	

}
