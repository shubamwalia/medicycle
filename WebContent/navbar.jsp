<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md shadow bg-white sticky-top">
  <a class="navbar-brand text-secondary font-weight-bold" href="Welcome.jsp">MediCycle</a>
  <!-- Navbar -->
<%
	String checkuser = (String)session.getAttribute("username");
	if(checkuser != null){
%>
 <ul class="navbar-nav ml-auto">
 	<li class="nav-item dropdown no-arrow mx-1"><a href="logout" class="btn btn-primary btn-lg active btn-sm" role="button">Logout</a></li>
 </ul>
<%	
}
%>
</nav>
