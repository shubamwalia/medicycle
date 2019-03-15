<%@page import="java.util.List"%>
<%@page import="com.pojo.Hospital"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="bootstraplinks.html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hospitals</h2>
<table class="table table-bordered" id="datatable" width="50%" cellspacing="0">
  <tr style="text-align:left">
    <th>Name</th>
    <th>City</th> 
  </tr>
 <c:forEach items="${hospitals}" var="hospital">
		<tr>
		<td>${hospital.name}</td>
		<td>${hospital.city}</td>
		</tr>
 </c:forEach>
</table>
</body>
</html>