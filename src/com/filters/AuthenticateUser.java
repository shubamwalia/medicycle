package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AuthenticateUser
 */
@WebFilter("/login")
public class AuthenticateUser implements Filter {

   
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if((username != null && username.equals("shubam")) && (password!=null && password.equals("1234"))) {
			chain.doFilter(request, response);
		}
		else {
			res.sendRedirect("Index.jsp");
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
