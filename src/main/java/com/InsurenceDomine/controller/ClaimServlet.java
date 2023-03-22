package com.InsurenceDomine.controller;
import java.io.IOException;
import java.io.PrintWriter;
import com.dbOperation.conm.DbOperation;
import insurance.customer.bean.ClaimBean;
import insurance.customer.bean.InsuranceDetails;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ClaimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ClaimServlet() {
    	super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("form hitted from Claim button");
			DbOperation db=new DbOperation();		 

		String rcl=request.getParameter("rclaim");		
		String damagetype=request.getParameter("typeda");		
		String doi=request.getParameter("dissue");
		 PrintWriter out=response.getWriter();

		
		if (damagetype.equals("PartiallyDamaged"))  {
			 ClaimBean claim=new ClaimBean();

			String []part=request.getParameterValues("dparts");
			Integer []goal=new Integer[part.length];
			
			 String rd="";  

		        for (int i = 0; i < part.length; i++) {
		        	
		        	if(part[i]!=null) {
		        
		        		 rd+=part[i];
		        	} 
		        }
			
			
		for (int i = 0; i < part.length; i++) {
			if(part[i]!=null) {
				part[i]="1";
			}else {
				part[i]="0";
			}
			
		}
		/*for (int i = 0; i < part.length; i++) {
			goal[i]=Integer.parseInt(part[i]);
		}
		for (Integer in : goal) {
			System.out.println(" goal values "+in);
		}
		
		
		
		
		//Integer[] summ= {10000,50000,15000,20000,15000,20000,15000};
		
	/*	if(goal[0]!=0) {sum1=10000; }	
		else if(goal[1]!=0) {sum2=50000; }	
		else if(goal[2]!=0) {sum3=15000; }	
		else if(goal[3]!=0) {sum4=20000; }	
		else if(goal[4]!=0) {sum5=15000; }	
		else if(goal[5]!=0) {sum6=20000; }	
		else {sum7=15000; }	
		*/
		int sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0,sum7=0;

		for (int i = 0; i < part.length; i++) {
			
			if(part[0]!=null) {sum1=10000; }	
			else if(part[1]!=null) {sum2=50000; }	
			else if(part[2]!=null) {sum3=15000; }	
			else if(part[3]!=null) {sum4=20000; }	
			else if(part[4]!=null) {sum5=15000; }	
			else if(part[5]!=null) {sum6=20000; }	
			else if(part[6]!=null) {sum7=15000; }	

			else {System.out.println("nothing"); }	
		}
		
		
		 int total=0;
		Integer []finalsum= {sum1,sum2,sum3,sum4,sum5,sum6,sum7};
		
		for (int i = 0; i < finalsum.length; i++) {
             total+=finalsum[i];
		}			
		/*
			if(duplicatestore[0]=="FrontGlass,") {add=10000; }	
			else if(duplicatestore[1]==" Engine,") { add1=50000; }
			else if(duplicatestore[2]==" FrontAndBummper,") {add2=15000; }
			else if(duplicatestore[3]==" Fender,") {add3=20000; }
			else if(duplicatestore[4]==" Hoodlid," ) { add4=15000; }
			else if(duplicatestore[5]==" Trunklid,") {add5=20000; }
			else {add6=15000;} */
			
			
			//String part1=request.getParameter("engine");
			//String part2=request.getParameter("frontandbumper");
			//String part3=request.getParameter("fender");
			//String part4=request.getParameter("hoodlid");
			//String part5=request.getParameter("dptrunklidarts5");
			//String part6=request.getParameter("frontandbackdoor");
			//int sum=0,sum1=0,sum2=0,sum3 = 0,sum4=0,sum5=0,sum6=0;
			//String part=request.getParameter("frontglass");
	        //String [] total= {part,part1,part2,part3,part4,part5,part6};
              //Integer[] summ= {10000,50000,15000,20000,15000,20000,15000};
			
       
       
        System.out.println(total);
        claim.setParts(rd);
		claim.setReasion(rcl);
		claim.setTypeOfDamage(damagetype);
		claim.setIssue(doi);
		claim.setSum(total);     

		
		int result=db.InsertClaim(claim);
		
		HttpSession session=request.getSession();
		session.setAttribute("ClaimObj", claim);
		
	RequestDispatcher req=request.getRequestDispatcher("/ClaimOrallView");
	RequestDispatcher fails=request.getRequestDispatcher("/Fail.html");
		
		if(result>0) {
			req.forward(request, response);
		}		
		
	}
		
		else {
		
		 ClaimBean claim=new ClaimBean();
			String part=request.getParameter("dparts");
			claim.setReasion(rcl);
			claim.setTypeOfDamage(damagetype);
			claim.setIssue(doi);
			String partsreplace="FULL VEHICLE LOSS";
			claim.setParts(partsreplace);			
			claim.setSum(0);
			
			int result=db.InsertClaim(claim);	
			
			HttpSession session=request.getSession();
		    session.setAttribute("ClaimObj", claim);
		    
		    Object obj=session.getAttribute("ClaimObj");
		    Object search=session.getAttribute("SearchObj");
		    InsuranceDetails cmr=null;
		    
		    claim=(ClaimBean)obj;
		    String date="";
			 if(search!=null) {
				 cmr=(InsuranceDetails)search;
				 date=cmr.getVrdate();
				 
			 }
			String sub= date.substring(0 ,4);
			int Regisdate=Integer.parseInt(sub);
		    String Cdate1=claim.getIssue();
			String cda=Cdate1.substring(0, 4);
			int IssueDate=Integer.parseInt(cda);
			
			if((IssueDate-Regisdate)<=3) {
				out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
						+ "<table >");
		 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;100% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASED&nbsp;UPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
		 		       out.print("<td>YOUR&nbsp; VEHICLE&nbsp; GET&nbsp; REPLACED&nbsp;</td>");
						out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

		 		      out.print("</table>");	
		 	         out.print("</body></head></html>");
			}
			else if((IssueDate-Regisdate)==4) {
				out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
						+ "<table >");
		 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM&nbspONLY &nbsp;86% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASED&nbsp;UPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
		 		       out.print("<td>BALANCE&nbsp; AMOUNT&nbsp; YOU&nbsp; HAVE&nbsp;TO&nbsp;PAY </td>");
						out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

		 		      out.print("</table>");	
		 	         out.print("</body></head></html>");
			}
			else if((IssueDate-Regisdate)==5) {
				out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
						+ "<table >");
		 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;75% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASED&nbsp;UPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
		 		       out.print("<td>BALANCE&nbsp; AMOUNT&nbsp; YOU&nbsp; HAVE&nbsp;TO&nbsp;PAY </td>");
						out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

		 		      out.print("</table>");	
		 	         out.print("</body></head></html>");
			}
			else if((IssueDate-Regisdate)==6) {
				out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
						+ "<table >");
		 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;60% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES&nbsp;BASED&nbsp;UPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
		 		       out.print("<td>BALANCE&nbsp; AMOUNT&nbsp; YOU&nbsp; HAVE&nbsp;TO&nbsp;PAY </td>");
						out.print("<tr><td><font \"><center><button ><a href='index.html'><span ><h3>INDEX-PAGE</h3></span></a></button></center></font></td></tr>");

		 		      out.print("</table>");	
		 	         out.print("</body></head></html>");
			}
			else if((IssueDate-Regisdate)==7) {
				out.print("<html><head><body><font><center><h3>YOUR&nbsp;CLAIM&nbsp;STATUS</h3></center></font>"
						+ "<table >");
		 		       out.print("<tr align='center'><td>YOU &nbsp;CAN &nbsp;CLAIM &nbsp;30% &nbsp;ACCORDING &nbsp;TO &nbsp;OUR&nbsp; POLICY&nbsp; RULES &nbsp;BASED&nbsp;UPON&nbsp; YOUR&nbsp; PA-COVER</td></tr>");
		 		       out.print("<td>BALANCE&nbsp; AMOUNT&nbsp; YOU&nbsp; HAVE&nbsp;TO&nbsp;PAY </td>");
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
}
