package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import com.pojo.Doctor;

public class DoctorDao {
	
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private String url = "jdbc:mysql://localhost:3306/medicycle";
	private String username = "root";
	private String password = "1234";
	private DataSource dataSource;
	
	
	
	
	public void addDoctor(String name,String designation) throws ClassNotFoundException, SQLException, NamingException {
	Class.forName("com.mysql.jdbc.Driver");
	this.connection = DriverManager.getConnection(this.url,this.username,this.password);
//		Context initContext  = new InitialContext();
//		Context envContext  = (Context)initContext.lookup("java:/comp/env");
//		dataSource = (DataSource)envContext.lookup("jdbc/medicycle");
//		
//		connection = dataSource.getConnection();
//		
		
		String query = "insert into doctor(name,designation) values(?,?)"; 
		this.preparedStatement = this.connection.prepareStatement(query);
		this.preparedStatement.setString(1,name);
		this.preparedStatement.setString(2, designation);
		this.preparedStatement.executeUpdate();
		this.preparedStatement.close();
		this.connection.close();
	}
	
	
	
	
	
	public List<Doctor> getDoctors() throws SQLException, ClassNotFoundException {
		List<Doctor> doctors = new ArrayList<Doctor>();
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		String query = "select * from doctor";
		this.statement = connection.createStatement();
		ResultSet resultSet = this.statement.executeQuery(query);

		while (resultSet.next()) {
			Doctor doctor = new Doctor();
			doctor.setName(resultSet.getString("name"));
			doctor.setDesignation(resultSet.getString("designation"));
			doctors.add(doctor);
		}
		this.connection.close();
		return doctors;
	}
}
