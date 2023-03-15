package com.insurance.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.insurance.details.InsuranceDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class DBOperations {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public DBOperations(){
		con=MySqlConnection.getInstance();
	}
	
	public int insertData(InsuranceDetails id) {
		int result=0;
		String query=" Insert INTO INSURANCE1 VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,id.getVregno());
			ps.setString(2, id.getVmake());
			ps.setString(3,id.getVmodel());
			ps.setInt(4, id.getVcc());
			ps.setString(5,id.getFueltype());
			ps.setString(6, id.getChassisno());
			ps.setLong(7, id.getEngineno());
			ps.setInt(8,id.getMfno());
			ps.setDate(9,(Date) id.getVrdate());
			ps.setString(10, id.getIname());
			ps.setString(11,id.getPolicyno());
			ps.setDate(12, (Date) id.getStartdate());
			ps.setDate(13, (Date) id.getExpirydate());
			ps.setDouble(14, id.getIdvalue());
			ps.setDouble(15, id.getPacover());
			ps.setInt(16,id.getNpassenger());
			ps.setInt(17, id.getNcb());
			ps.setString(18, id.getName());
			ps.setString(19, id.getAddress());
			ps.setLong(20, id.getPincode());
			ps.setLong(21, id.getMobileno());
			ps.setString(22, id.getEmailid());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(	result+"Rows effected");
		return result;
	}

	public static void main(String[] args) {
		
		DBOperations db=new DBOperations();
		InsuranceDetails Idetails=new InsuranceDetails();
		int result=db.insertData(Idetails);
		if(result>0) {
			System.out.println("Data Inserted");
		}else {
			System.out.println("Please try again");
		}

	}

}
