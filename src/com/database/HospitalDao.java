package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Hospital;

public class HospitalDao {
	private Connection connection;
	private Statement statement;
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
	
	public List<Hospital> getHospitals() throws SQLException, ClassNotFoundException {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(this.url,this.username,this.password);
		String query = "select * from hospital"; 
		this.statement = this.connection.createStatement();
		ResultSet resultSet = this.statement.executeQuery(query);
		
		while(resultSet.next()) {
			Hospital hospital = new Hospital();
			hospital.setName(resultSet.getString("name"));
			hospital.setCity(resultSet.getString("city"));
			hospitals.add(hospital);
		}
		this.connection.close();
		return hospitals;
	}
}
