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

import com.database.DoctorDao;
import com.pojo.Doctor;

@WebServlet("/viewdoctor")
public class ViewDoctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DoctorDao doctorDao = new DoctorDao();
		List<Doctor> doctors = null;
		try {
			doctors = doctorDao.getDoctors();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("doctors",doctors);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewDoctors.jsp");
		requestDispatcher.forward(request, response);
	}
}
