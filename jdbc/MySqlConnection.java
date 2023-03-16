package com.insurance.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.insurance.jdbc.MySqlConnection;

public class MySqlConnection {

	private static MySqlConnection mysqlconnection = new MySqlConnection();
	Connection connection;

	private MySqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?autoReconnect=true&useSSL=false", "root", "Shraddha@97");
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