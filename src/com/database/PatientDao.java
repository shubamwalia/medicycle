package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Patient;

public class PatientDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private String url = "jdbc:mysql://localhost:3306/medicycle";
	private String username = "root";
	private String password = "1234";

	public void addPatient(String name, String disease) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		String query = "insert into patient(name,disease) values(?,?)";
		this.preparedStatement = this.connection.prepareStatement(query);
		this.preparedStatement.setString(1, name);
		this.preparedStatement.setString(2, disease);
		this.preparedStatement.executeUpdate();
		this.preparedStatement.close();
		this.connection.close();
	}

	public List<Patient> getPatients() throws SQLException, ClassNotFoundException {
		List<Patient> patients = new ArrayList<Patient>();
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		String query = "select * from patient";
		this.statement = connection.createStatement();
		ResultSet resultSet = this.statement.executeQuery(query);

		while (resultSet.next()) {
			Patient patient = new Patient();
			patient.setName(resultSet.getString("name"));
			patient.setDisease(resultSet.getString("disease"));
			patients.add(patient);
		}
		this.connection.close();
		return patients;
	}
}
