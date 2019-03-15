<%@page import="com.database.UserDao"%>
<%@page import="com.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md shadow bg-white sticky-top">
  <a class="navbar-brand text-secondary font-weight-bold" href="Welcome.jsp">MediCycle</a>
  <!-- Navbar -->
<%
	String username2 = (String)session.getAttribute("username");
	String password2 = (String)session.getAttribute("password");
	UserDao userDao2 = new UserDao();
    User user2 = userDao2.getUser(username2, password2);
	pageContext.setAttribute("user",user2);
	String checkuser = (String)session.getAttribute("username");
	if(checkuser != null){
%>
 <ul class="navbar-nav ml-auto">
    <li class="nav-item dropdown no-arrow mx-1"><span class="badge badge-pill badge-success">${user.role}</span></li>
    <li class="nav-item dropdown no-arrow mx-1"><span class="badge badge-pill badge-info">${user.name}</span></li>
 	<li class="nav-item dropdown no-arrow mx-1"><a href="logout" class="btn btn-outline-danger btn-sm" role="button">Logout</a></li>
 </ul>
<%	
}
%>
</nav>
