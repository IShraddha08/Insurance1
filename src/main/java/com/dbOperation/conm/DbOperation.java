package com.dbOperation.conm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import insurance.customer.bean.ClaimBean;
import insurance.customer.bean.InsuranceDetails;

	public class DbOperation {
		Connection connection;
		PreparedStatement preparedstatement;
		ResultSet rs;
		public DbOperation() {
			connection = MySqlConnection.getInstance();
		}
	
    public int insertInsuranceDetails(InsuranceDetails s) {
    	int result=0;
    	String query="insert into InsuranceDetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    	try {

    	preparedstatement=connection.prepareStatement(query);
    	preparedstatement.setString(1,s.getVregno());
    	preparedstatement.setString(2,s.getVmake());
    	preparedstatement.setString(3,s.getVmodel());
    	preparedstatement.setInt   (4,s.getVcc());
    	preparedstatement.setString(5,s.getFueltype());
    	preparedstatement.setString(6,s.getChassisno());
    	preparedstatement.setNString(7,s.getEngineno());
    	preparedstatement.setInt    (8,s.getMfno());
        preparedstatement.setString(9,  s.getVrdate());    	
    	preparedstatement.setString(10,s.getIname());
    	preparedstatement.setString(11,s.getPolicyno());
    	preparedstatement.setString(12, s.getStartdate());
    	preparedstatement.setString(13,s.getExpirydate()); 
    	preparedstatement.setString(14,s.getIdvalue());
    	preparedstatement.setDouble(15,s.getPacover());
    	preparedstatement.setString(16,s.getNpassenger());
    	preparedstatement.setInt   (17,s.getNcb());
    	preparedstatement.setString(18,s.getName());
        preparedstatement.setString(19,s.getAddress());
    	preparedstatement.setString(20,s.getPincode());
    	preparedstatement.setString(21,s.getMobileno());
    	preparedstatement.setString(22,s.getEmailid());
    	
    	result=preparedstatement.executeUpdate();

    	}
    	catch(SQLException e) {e.printStackTrace();}

    	return result;
        }
    public List<InsuranceDetails> FetchDataWithPreparedStatement() { 
		List<InsuranceDetails> listofdetails = new ArrayList<InsuranceDetails>();
		String query = "select * from InsuranceDetails";
		try {
			
			preparedstatement = connection.prepareStatement(query); 
				rs = preparedstatement.executeQuery();
			InsuranceDetails r = null; 
			while (rs.next()) {
				 r = new InsuranceDetails();
				 r.setVregno(rs.getString(1));  
				 r.setVmake(rs.getString(2)); 
				 r.setVmodel(rs.getString(3)); 
			     r.setVcc(rs.getInt(4)); 
				 r.setFueltype(rs.getString(5));
				 r.setChassisno(rs.getString(6)); 
				 r.setEngineno(rs.getString(7)); 
				 r.setMfno(rs.getInt(8));
				 r.setVrdate(rs.getString(9)); 
			     r.setIname(rs.getString(10)); 
				 r.setPolicyno(rs.getString(11));
				 r.setStartdate( rs.getString(12));
				 r.setExpirydate( rs.getString(13)); 
			     r.setIdvalue(rs.getString(14));
				 r.setPacover(rs.getDouble(15)); 
				 r.setNpassenger(rs.getString(16)); 
				 r.setNcb(rs.getInt(17)); 
			     r.setName(rs.getString(18)); 
				 r.setAddress(rs.getString(19));
				 r.setPincode(rs.getString(20)); 
			   	 r.setMobileno(rs.getString(21)); 
			     r.setEmailid(rs.getString(22)); 
				 listofdetails.add(r); 
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listofdetails; 

	}
    public int InsertClaim(ClaimBean s ) {
    	int result=0;
    	String query="insert into claimdata values(?,?,?,?,?)";
    	try {
			preparedstatement=connection.prepareStatement(query);
			preparedstatement.setString(1,s.getReasion());
	    	preparedstatement.setObject(2, s.getTypeOfDamage());
	    	preparedstatement.setString(3, s.getIssue());
	    	preparedstatement.setObject(4,s.getParts());
	    	preparedstatement.setInt   (5,s.getSum());    	
    	
	    	 result=preparedstatement.executeUpdate();

    	} catch (SQLException e) {
			e.printStackTrace();
		}    	
    	return result;
    }
    public InsuranceDetails Searchdata(String name) {
    	InsuranceDetails result=null;
		String query="select * from insurancedetails where name=?";
		try {
		preparedstatement =connection.prepareStatement(query);		
		preparedstatement.setString(1,name);
		rs=preparedstatement.executeQuery();
		while(rs.next()) {
			result=new InsuranceDetails();
			result.setName(rs.getString("name"));
			result.setPolicyno(rs.getString("policyno"));
			result.setVregno(rs.getString("vregno"));
			result.setVmake(rs.getString("vmake"));
			result.setVrdate(rs.getString("vrdate"));
			result.setVmodel(rs.getString("vmodel"));
			result.setStartdate(rs.getString("startdate"));
			result.setExpirydate(rs.getString("expirydate"));
			result.setIdvalue(rs.getString("idvalue"));

		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
    
    public static void main(String[] args) throws ParseException {
    	
    	DbOperation cv=new DbOperation();
    	/*ClaimBean rrr= new ClaimBean();
    	rrr.setReasion("nothinh");
    	rrr.setParts("glasss");
    	rrr.setTypeOfDamage("accident");
    	rrr.setIssue("12/45/89");
    	rrr.setSum(12546);
    	InsuranceDetails r=new InsuranceDetails();
		DateFormat dt= new SimpleDateFormat("YYYY/MM/DD");
		int result=cv.InsertClaim(rrr);
*/

    	
	}
}
