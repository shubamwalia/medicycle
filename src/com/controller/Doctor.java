package com.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.database.DoctorDao;

@WebServlet("/adddoctor")
public class Doctor extends HttpServlet {
	@Resource(name="jdbc/medicycle")
	private DataSource dataSource;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		
		DoctorDao doctorDao = new DoctorDao();
		
		
		try {
			doctorDao.addDoctor(name, designation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Welcome.jsp?add=success");
	}

}
