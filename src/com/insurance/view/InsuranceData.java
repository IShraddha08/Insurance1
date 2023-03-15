package com.insurance.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurance.details.InsuranceDetails;


public class InsuranceData extends HttpServlet {

	
		public InsuranceData() {
			super();
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			response.setContentType("text/html");
			
			HttpSession response1=request.getSession();
			Object obj=response1.getAttribute("InsuranceObject");
			
			InsuranceDetails Id=null;
			
			
			
			if(obj!=null) {
				Id=(InsuranceDetails)obj;
			}
			
			PrintWriter pw=response.getWriter();
		   
		
			
			pw.print("<html><body><h1>Registraion Form</h1><body><h2>Vehicle Details</h2><table>");
			pw.print("<tr><th>VeicleRegNo</th><th>VehicleMake</th><th>Vehiclemodel</th><th>VCC</th><th>Fueltype</th><th>ChassisNo</th><th>EngineNo</th><th>ManufacturingYear</th></tr>");
			pw.print("<tr><td>"+Id.getVregno()+"</td>");
	       	pw.print("<td>"+Id.getVmake()+"</td>");
	       	pw.print("<td>"+Id.getVmodel()+"</td>");
	       	pw.print("<td>"+Id.getVcc()+"</td>");
	       	pw.print("<td>"+Id.getFueltype()+"</td>");
	       	pw.print("<td>"+Id.getChassisno()+"</td>");
	       	pw.print("<td>"+Id.getEngineno()+"</td>");
	       	pw.print("<td>"+Id.getMfno()+"</td>");
	       	pw.print("<td>"+Id.getVrdate()+"</td></tr>");
	       	pw.print("</table></body>");
	       	
            pw.print("<body><h2>Policy Details</h2><table>");
            pw.print("<tr><th>InsuredName</th><th>PolicyNo</th><th>PolicyStartDate</th><th>PolicyExpiryDate</th><th>InsuredValue</th><th>PACoverPassenger</th><th>NPassengers</th><th>Eligible NCB</th></tr>");
            pw.print("<tr><td>"+Id.getIname()+"</td>");
	       	pw.print("<td>"+Id.getPolicyno()+"</td>");
	       	pw.print("<td>"+Id.getStartdate()+"</td>");
	       	pw.print("<td>"+Id.getExpirydate()+"</td>");
	       	pw.print("<td>"+Id.getIdvalue()+"</td>");
	       	pw.print("<td>"+Id.getPacover()+"</td>");
	       	pw.print("<td>"+Id.getNpassenger()+"</td>");
	       	pw.print("<td>"+Id.getNcb()+"</td></tr>");
	       	pw.print("</table></body>");
            
	       	
		    pw.print("<body><h2>Personal Details</h2><table>");
		    pw.print("<tr><th>Name</th><th>EmailId</th><th>Address</th><th>Pincode</th><th>MobileNo</th></tr>");
		    pw.print("<tr><td>"+Id.getName()+"</td>");
	       	pw.print("<td>"+Id.getEmailid()+"</td>");
	       	pw.print("<td>"+Id.getAddress()+"</td>");
	       	pw.print("<td>"+Id.getPincode()+"</td>");
	       	pw.print("<td>"+Id.getMobileno()+"</td></tr>");
			pw.print("<tr><td><button><a href='index.html'>Return</a></td></tr>");
		    pw.print("</table></body></body></html>");
		}
		
}
