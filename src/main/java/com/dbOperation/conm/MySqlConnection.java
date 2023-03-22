package com.dbOperation.conm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnection {

	private static MySqlConnection mysqlconnection = new MySqlConnection();
	Connection connection;

	private MySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?autoReconnect=true&useSSL=false", "root", "111003");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getInstance() {
		return mysqlconnection.connection;
		
	}
	public static void main(String[] args) {
		System.out.println(MySqlConnection.getInstance());
	}

}