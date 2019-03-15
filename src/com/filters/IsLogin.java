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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class IsLogin
 */
@WebFilter(urlPatterns = {"/viewhospital","/viewdoctor","/viewpatient"})
public class IsLogin implements Filter {

	@Override
	public void destroy() {
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession httpSession = req.getSession();
		String username = (String)httpSession.getAttribute("username");
		if(username != null) {
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
