package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HospitalDao {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String url = "jdbc:mysql://localhost:3306/medicycle";
	private String username = "root";
	private String password = "1234";
	public void addHospital(String name,String city) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(this.url,this.username,this.password);
		String query = "insert into hospital(name,city) values(?,?)"; 
		this.preparedStatement = this.connection.prepareStatement(query);
		this.preparedStatement.setString(1,name);
		this.preparedStatement.setString(2, city);
		this.preparedStatement.executeUpdate();
		this.preparedStatement.close();
		this.connection.close();
	}
}
