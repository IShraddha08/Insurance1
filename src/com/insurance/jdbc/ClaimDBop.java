package com.InsuranceDomain.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.insurance.details.ClaimBean;
import java.util.Arrays;

public class ClaimDBop {
	Connection connection;
	PreparedStatement preparedstatement;
	
	public ClaimDBop() {
		connection = MySqlConnection.getInstance();
	}
	public int insertclaimdetails (ClaimBean c) {
		int r2=0;
    	String query="insert into InsuranceDetails(reclaim,dparts,tdamage,dissue,sum) values(?,?,?,?,?)";
    	try {
    		preparedstatement=connection.prepareStatement(query);
        	
        	preparedstatement.setString(1,c.getreclaim());
        	
        	  String[] dpartsarr = c.getdparts();
        	  String dpartscol = "";
        	  for (int i = 0; i < dpartsarr.length; i++) {
        		  dpartscol  += dpartsarr[i]+ " ";  /*spaceseparated values*/
          	  preparedstatement.setString(2, dpartscol);
        	  }
        	preparedstatement.setString(3,c.gettdamage());
            preparedstatement.setDate(4,(Date)c.getdissue());
            preparedstatement.setInt(5,c.getsum());
    	}
}catch (SQLException e) {
	e.printStackTrace();
}
return r2;
}

}

