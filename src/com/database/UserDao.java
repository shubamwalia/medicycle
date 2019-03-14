package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String url = "jdbc:mysql://localhost:3306/medicycle";
	private String username = "root";
	private String password = "1234";
	public boolean authenticate(String username,String password) throws ClassNotFoundException, SQLException {
		boolean auth = false;
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(this.url,this.username,this.password);
		String query = "select * from user where username=? AND password=?"; 
		this.preparedStatement = this.connection.prepareStatement(query);
		this.preparedStatement.setString(1,username);
		this.preparedStatement.setString(2, password);
		ResultSet resultSet = this.preparedStatement.executeQuery();
		if(resultSet.next()) {
			auth = true;
		}
		this.preparedStatement.close();
		this.connection.close();
		return auth;
	}
}
