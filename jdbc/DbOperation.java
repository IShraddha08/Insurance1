package com.insurance.jdbc;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;
import com.insurance.details.InsuranceDetails;
import java.sql.SQLException;

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
    	preparedstatement.setInt(4,s.getVcc());
    	preparedstatement.setString(5,s.getFueltype());
    	preparedstatement.setString(6,s.getChassisno());
    	preparedstatement.setLong(7,s.getEngineno());
    	preparedstatement.setInt(8,s.getMfno());
    	preparedstatement.setDate(9,  (Date)s.getVrdate());
    	preparedstatement.setString(10,s.getVregno());
    	preparedstatement.setString(11,s.getIname());
    	preparedstatement.setString(12,s.getPolicyno());
    	preparedstatement.setDate(13, (Date)s.getStartdate());
    	preparedstatement.setDate(14, (Date)s.getExpirydate()); 
    	preparedstatement.setDouble(15,s.getIdvalue());
    	preparedstatement.setDouble(16,s.getPacover());
    	preparedstatement.setInt(17,s.getNpassenger());
    	preparedstatement.setInt(18,s.getNcb());
    	preparedstatement.setString(19,s.getName());
    	preparedstatement.setLong(20,s.getPincode());
    	preparedstatement.setLong(21,s.getMobileno());
    	preparedstatement.setString(22,s.getEmailid());
    	result=preparedstatement.executeUpdate();
    	}catch(SQLException e) {
    	e.printStackTrace();
    }
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
				r.setEngineno(rs.getLong(7)); 
				 r.setMfno(rs.getInt(8));
				r.setVrdate(rs.getDate(9)); 
			 r.setIname(rs.getString(10)); 
				 r.setPolicyno(rs.getString(11));
				 r.setStartdate( rs.getDate(12));
				 r.setExpirydate( rs.getDate(13)); 
			 r.setIdvalue(rs.getDouble(14));
				 r.setPacover(rs.getDouble(15)); 
				 r.setNpassenger(rs.getInt(16)); 
				 r.setNcb(rs.getInt(17)); 
			 r.setName(rs.getString(18)); 
				 r.setAddress(rs.getString(19));
				 r.setPincode(rs.getLong(20)); 
				r.setMobileno(rs.getLong(21)); 
			 r.setEmailid(rs.getString(22)); 
				 listofdetails.add(r); 
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listofdetails; 

	}
}