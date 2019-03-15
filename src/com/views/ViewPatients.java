package com.views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.PatientDao;
import com.pojo.Patient;


@WebServlet("/viewpatient")
public class ViewPatients extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatientDao patientDao = new PatientDao();
		List<Patient> patients = null;
		try {
			patients = patientDao.getPatients();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("patients",patients);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewPatients.jsp");
		requestDispatcher.forward(request, response);
	}

}
