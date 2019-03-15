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

import com.database.HospitalDao;
import com.pojo.Hospital;

/**
 * Servlet implementation class ViewHospital
 */
@WebServlet("/viewhospital")
public class ViewHospital extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalDao hospitalDao = new HospitalDao();
		List<Hospital> hospitals = null;
		try {
			hospitals = hospitalDao.getHospitals();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("hospitals",hospitals);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewHospitals.jsp");
		requestDispatcher.forward(request, response);
	}


}
